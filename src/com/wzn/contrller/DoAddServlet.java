package com.wzn.contrller;

import com.wzn.pojo.Product;
import com.wzn.service.IProductService;
import com.wzn.service.ProductServiceImlp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doAdd")
public class DoAddServlet extends HttpServlet {
    private IProductService service = new ProductServiceImlp();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        Double price= Double.parseDouble(req.getParameter("price"));
        String des=req.getParameter("des");
        Product p=new Product();
        p.setProductName(name);
        p.setDes(des);
        p.setProductPrice(price);
        service.add(p);
        resp.sendRedirect("list");


    }
}
