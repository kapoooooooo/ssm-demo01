package cn.kapooo.ssm.controller;


import cn.kapooo.ssm.anno.RequiredPermission;
import cn.kapooo.ssm.domain.Permission;
import cn.kapooo.ssm.qo.QueryObject;
import cn.kapooo.ssm.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    // 处理查询所有权限请求
    @RequestMapping("/list")
    public ModelAndView list(QueryObject qo){
        ModelAndView mv = new ModelAndView();
        //分页查权限数据
        PageInfo<Permission> pageInfo = permissionService.selectForList(qo);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("permission/list");
        return mv; // 找视图 /WEB-INF/views/permission/list.jsp
    }

    /**
     * 发起请求：
     * Request URL： http://localhost:8081/permission/reload
     *
     * 自定义的注解@RequiredPermission贴在方法上面
     * 方法是存在控制器里面的，而控制器是在容器里面的。
     *
     * 步骤：
     * 1、获取容器
     * 2、通过容器获取，容器里面贴有 @Controller注解的控制器
     * 3、通过控制强，获取控制器里面的方法
     *  3.1、有的方法上面贴有注解 @RequiredPermission
     *  3.2、有的方法上面没有贴自定义注解，没贴自定义注解的方法表示所有人都可以访问
     * 4、获取方法上面贴的注解
     * 5、获取到的注解里面的值：name 、 expression
     */
    // 1、获取容器
    @Autowired
    private ApplicationContext ctx;
    @RequestMapping("/reload")
    public String reload(){
        //获取当前已有权限表达式
        List<String> expressionList = permissionService.selectAllExpression();
        List<Permission> permissionList = new ArrayList<>();
        // 2、通过容器获取，容器里面贴有 @Controller注解的控制器
        Map<String, Object> beansMap = ctx.getBeansWithAnnotation(Controller.class);
        Collection<Object> controllers = beansMap.values();
        for (Object controller : controllers) {
            // 3、通过控制强，获取控制器里面的方法
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                RequiredPermission anno = method.getAnnotation(RequiredPermission.class);
                // 3.1、有的方法上面贴有注解 @RequiredPermission
                if (anno != null){
                    Permission permission = new Permission();
                    permission.setName(anno.name());
                    permission.setExpression(anno.expression());
                    // 判断权限表达式是否存在
                    if (!expressionList.contains(permission.getExpression())){
                        //添加到PermissionList中
                        permissionList.add(permission);
                    }
                }
            }
        }
        //批量插入
        permissionService.save(permissionList);
        //回到列表页面
        return "redirect:/permission/list";
    }

    @RequestMapping("/nopermission")
    public String nopermission(){
        return "/common/nopermission";
    }
}
