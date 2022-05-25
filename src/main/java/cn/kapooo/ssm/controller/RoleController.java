package cn.kapooo.ssm.controller;

import cn.kapooo.ssm.anno.RequiredPermission;
import cn.kapooo.ssm.domain.Permission;
import cn.kapooo.ssm.domain.Role;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IPermissionService;
import cn.kapooo.ssm.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    // 处理查询所有角色请求
    @RequiredPermission(name = "角色列表", expression = "role:list")
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //分页查角色数据
        PageInfo<Role> pageInfo = roleService.selectForList(qo);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role/list");
        return mv; // 找视图 /WEB-INF/views/role/list.jsp
    }

    // 判断添加/修改角色
    @RequestMapping("/input")
    public String input(Long id, Model model){
        //查全部权限数据
        List<Permission> permissionList = permissionService.selectAll();
        model.addAttribute("permissionList",permissionList);
        if (id != null) { //有id => 表示去修改
            //根据角色id查角色数据
            Role role = roleService.selectById(id);
            model.addAttribute("role", role);
            //根据角色id查角色拥有权限的数据
            List<Permission> ownPermissionList = permissionService.selectAllByRoleId(id);
            model.addAttribute("ownPermissionList",ownPermissionList);
        }
        return "role/input"; //完成操作后重新回到list页面
    }

    //处理保存或修改角色的请求
    @RequiredPermission(name = "角色新增或修改", expression = "role:saveOrUpdate")
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role role, Long[] permissionIds){
        if (role.getId() == null){//无id => 保存角色信息
            //保存角色信息
            roleService.save(role,permissionIds);
        }else{//有id 修改部门信息
            roleService.update(role,permissionIds);
        }
        return "redirect:/role/list"; //完成操作后重新回到list页面
    }

    // 处理删除角色请求
    @RequiredPermission(name = "角色删除", expression = "role:delete")
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            //根据角色id删除角色数据
            roleService.delete(id);
        }
        return "redirect:/role/list"; //完成操作后重新回到list页面
    }
}
