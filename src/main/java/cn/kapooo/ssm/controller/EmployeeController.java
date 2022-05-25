package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.anno.RequiredPermission;
import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.domain.Permission;
import cn.kapooo.ssm.domain.Role;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IDepartmentService;
import cn.kapooo.ssm.service.IEmployeeService;
import cn.kapooo.ssm.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController{

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IRoleService roleService;

    // 处理查询所有员工请求
    @RequiredPermission(name = "员工列表", expression = "employee:list")
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //分页查员工数据
        PageInfo<Employee> pageInfo = employeeService.selectForList(qo);
        //设置到作用域中
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("employee/list");
        return mv; // 找视图 /WEB-INF/views/employee/list.jsp
    }

    // 判断添加/修改员工请求
    @RequestMapping("/input")
    public String input(Long id, Model model){
        //查询所有员工信息
        List<Department> departmentList = departmentService.selectAll();
        //查全部角色数据
        List<Role> roleList = roleService.selectAll();
        // 设置到作用域中，让员工添加/修改时显示出来以供用户选择
        model.addAttribute("roleList",roleList);
        model.addAttribute("departmentList", departmentList);
        if (id != null) { // 有id => 修改员工
            //根据员工id查询员工数据
            Employee employee = employeeService.selectById(id);
            //根据员工id查员工拥有角色的数据
            List<Role> ownRoleList = roleService.selectAllByEmployeeId(employee.getId());
            //设置到作用域中
            model.addAttribute("ownRoleList",ownRoleList);
            model.addAttribute("employee", employee);
        }
        return "/employee/input"; //完成操作后重新回到list页面
    }

    //处理保存/修改员工的请求
    @RequiredPermission(name = "员工添加或修改", expression = "employee:saveOrUpdate")
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Employee employee,Long[] roleIds){
        if (employee.getId() == null){//无id => 添加员工信息
            employeeService.save(employee, roleIds);
        }else{//有id => 修改员工信息
            employeeService.update(employee, roleIds);
        }
        return "redirect:/employee/list"; //完成操作后重新回到list页面
    }

    // 处理删除员工请求
    @RequiredPermission(name = "员工删除", expression = "employee:delete")
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据员工id删除员工数据
            employeeService.delete(id);
        }
        return "redirect:/employee/list"; //完成操作后重新回到list页面求
    }
    // 处理重置员工登录尝试次数
    @RequiredPermission(name = "员工登录次数重置", expression = "employee:reset")
    @RequestMapping("/reset")
    public String reset(Long id){
        if (id != null) {
            //根据员工重置登录尝试次数
            employeeService.updateTestNumByEmployeeId(id, 1);
        }
        return "redirect:/employee/list"; //完成操作后重新回到list页面求
    }
}
