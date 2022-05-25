package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.qo.JsonResult;
import cn.kapooo.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private HttpSession session;

    private static Integer MAX_FAIL_COUNT = 3;
    private static String LOGIN_FAIL_COUNT="LOGIN_FAIL_COUNT";
    private static String USER_IN_SESSION="USER_IN_SESSION";

    // 处理登录请求
    @ResponseBody
    @RequestMapping("/login")
    public JsonResult login(String username, String password, Model model) {
        //通过账号取出账号密码和登录次数
        Employee employee = employeeService.selectLoginByUsername(username);
        if(employee != null){
            if (password.equals(employee.getPassword()) && employee.getTestNum()<= MAX_FAIL_COUNT - 1){
                //设置登录用户数据到session
                session.setAttribute(USER_IN_SESSION, employee);
                //重置登录尝试次数
                employeeService.updateTestNumByEmployeeId(employee.getId(), 1);

                return JsonResult.success("成功", employee);
            }else if (employee.getTestNum() <= MAX_FAIL_COUNT - 1 ) {
                //登录尝试次数+1
                employeeService.updateTestNumByEmployeeId(employee.getId(), employee.getTestNum() + 1);

                return JsonResult.fail("错误三次，账号会被锁定，剩余" + (MAX_FAIL_COUNT - employee.getTestNum()) + "次");
            }
            return JsonResult.fail("错误三次账号已被锁定");
        }
        return JsonResult.fail("该账号不存在");
    }

    @RequestMapping("/logout")
    public String logout(){
        //清除作用域
        session.removeAttribute("USER_IN_SESSION");
        //回到登录界面
        return "redirect:/login.html";
    }
}
