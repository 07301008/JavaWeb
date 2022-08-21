package com.itlxl.web;

import com.itlxl.pojo.User;
import com.itlxl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    // 创建Service对象
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、接受数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2、封装对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        // 3、调用service查询
        boolean register = userService.register(user);
        // 4、判断
       if (register == true){
           // 注册成功
           request.setAttribute("register_msg","注册成功，请登录");
           request.getRequestDispatcher("/login.jsp").forward(request,response);
       }else {
           // 注册失败
           request.setAttribute("register_msg","用户名已存在");
           request.getRequestDispatcher("/register.jsp").forward(request,response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
