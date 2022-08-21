package com.itlxl.web;

import com.itlxl.pojo.Brand;
import com.itlxl.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    // 创建Service对象
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、调用BrandServlet完成查询
        List<Brand> brands = brandService.selectAll();

        // 2、存入request域中国
        request.setAttribute("brands",brands);
        /*HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        request.setAttribute("user",user);*/

        // 3、转发到brand.jsp
        request.getRequestDispatcher("/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
