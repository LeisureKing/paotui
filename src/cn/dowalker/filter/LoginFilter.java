package cn.dowalker.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class LoginFilter implements Filter{
 
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
         
    }
     
    public void destroy() {
        // TODO Auto-generated method stub
         
    }
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        //获取HttpSession对象，判断是否登陆
        HttpServletRequest req =  (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
         
        if(session.getAttribute("user")==null){
            res.sendRedirect(req.getContextPath() + "/user/toMemberLogin.html");
        }else{
            // 如果有下一个过滤器则跳转到下一个过滤器否则目标页面
            chain.doFilter(request, response);
        }
    }
 
 
}