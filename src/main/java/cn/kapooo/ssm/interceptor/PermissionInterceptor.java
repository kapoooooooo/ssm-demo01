package cn.kapooo.ssm.interceptor;

import cn.kapooo.ssm.anno.RequiredPermission;
import cn.kapooo.ssm.domain.Employee;
import cn.kapooo.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 分析
     * 1、超级管理员放行。 return true
     * 2、方法上面没有贴自定义注解。 return true
     * 3、如果当前方法贴了注解，用户拥有权限。 return true
     * 4、其他的  return false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从作用域中获取值
        Employee employee = (Employee)request.getSession().getAttribute("USER_IN_SESSION");
        // 1、超级管理员放行。 return true
        if (employee != null && employee.isAdmin()){
            return true;
        }
        HandlerMethod method = (HandlerMethod)handler;
        RequiredPermission anno = method.getMethodAnnotation(RequiredPermission.class);
        // 2、方法上面没有贴自定义注解。 return true
        if(anno == null){
            return true;
        }
        List<String> expressionList = permissionService.selectExpressionByEmployeeId(employee.getId());
        String expression = anno.expression();
        // 3、如果当前方法贴了注解，用户拥有权限。 return true
        if (expressionList.contains(expression)){
            return true;
        }
        // 4、其他的  return false
        response.sendRedirect("/permission/nopermission");
        return false;
    }
}
