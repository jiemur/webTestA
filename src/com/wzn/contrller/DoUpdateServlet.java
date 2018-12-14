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
@WebServlet("/doUpdate")
public class DoUpdateServlet extends HttpServlet {
    private IProductService service=new ProductServiceImlp();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name= req.getParameter("name");
        double price=Double.parseDouble(req.getParameter("price"));
        String des= req.getParameter("des");
        System.out.println(id);
        System.out.println(name);
        Product p=new Product();
        p.setProductName(name);
        p.setProductPrice(price);
        p.setDes(des);
        p.setProductId(id);
        service.update(p);
        resp.sendRedirect("list");
    }
}
