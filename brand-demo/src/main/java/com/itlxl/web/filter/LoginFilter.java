package com.itlxl.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证过滤器
 */
@WebFilter( "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        // 判断访问资源路径是否和登录注册相关
        String[] urls = {"/login.jsp","/loginServlet","/register.jsp","/registerServlet"};
        // 获取当前访问资源路径
        String url = req.getRequestURL().toString();
        // 遍历数组
        for (String u : urls) {
            if (url.contains(u)){
                // 找到了，放行
                chain.doFilter(request,response);
                return;
            }
        }
        // 1、判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null){
            // 登录过了
            chain.doFilter(request, response);
        }else {
            // 没有登录
            req.setAttribute("login_msg","您尚未登录！");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }

    }
}
