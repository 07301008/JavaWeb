package com.itlxl.web;

import com.itlxl.pojo.Brand;
import com.itlxl.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    // 创建Service对象
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、接受id
        String id = request.getParameter("id");
        // 2、调用service查询
        Brand brand = brandService.selectById(Integer.parseInt(id));
        // 3、存到request中
        request.setAttribute("brand",brand);
        // 4、转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
