package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.anno.RequiredPermission;
import cn.kapooo.ssm.domain.Department;
import cn.kapooo.ssm.qo.PageResult;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IDepartmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    // 处理查询所有部门请求
    @RequiredPermission(name = "部门列表", expression = "department:list")
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //分页查部门数据
        PageInfo<Department> pageInfo = departmentService.selectForList(qo);
        //设置到作用域中
        mv.addObject("pageInfo", pageInfo);

        mv.setViewName("department/list");
        return mv; // 找视图 /WEB-INF/views/department/list.jsp
    }

    // 判断添加/修改部门请求
    @RequestMapping("/input")
    public String input(Long id, Model model){
        if (id != null) {//有id => 表示去修改
            //根据部门id查询部门数据
            Department department = departmentService.selectById(id);
            //设置到作用域中
            model.addAttribute("department", department);
        }
        return "/department/input"; //完成操作后重新回到list页面
    }

    //处理保存/修改部门的请求
    @RequiredPermission(name = "部门添加或修改", expression = "department:saveOrUpdate")
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Department department){
        if (department.getId() == null){//无id => 保存部门信息
            departmentService.save(department);
        }else{//有id => 修改部门信息
            departmentService.update(department);
        }
        return "redirect:/department/list"; //完成操作后重新回到list页面
    }

    // 处理删除请求
    @RequiredPermission(name = "部门删除", expression = "department:delete")
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据部门id删除部门数据
            departmentService.delete(id);
        }
        return "redirect:/department/list"; //完成操作后重新回到list页面
    }
}
