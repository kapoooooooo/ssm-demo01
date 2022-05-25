package cn.kapooo.ssm.interceptor;

import cn.kapooo.ssm.domain.Employee;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从作用域中获取值
        Employee employee = (Employee)request.getSession().getAttribute("USER_IN_SESSION");
        //作用域有值,已经登录过
        if(employee != null){
            return true;
        }else
        response.sendRedirect("/login.html");
        return false;
    }
}
