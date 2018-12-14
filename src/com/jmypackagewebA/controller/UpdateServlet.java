package com.jmypackagewebA.controller;

import com.jmypackagewebA.pojo.Product;
import com.jmypackagewebA.service.IProductService;
import com.jmypackagewebA.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        Product p = service.getOne(id);
        req.setAttribute("p",p);
        req.getRequestDispatcher("WEB-INF/pages/update.jsp").forward(req,resp);
    }
}