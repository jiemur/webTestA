package com.wzn.contrller;

import com.wzn.service.IProductService;
import com.wzn.service.ProductServiceImlp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/delete")
public class DeletServlet extends HttpServlet {
    private IProductService service=new ProductServiceImlp();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id=Integer.parseInt(req.getParameter("productId"));
         service.delete(id);
         resp.sendRedirect("list");
    }
}
