package com.wzn.contrller;

import com.wzn.pojo.Product;
import com.wzn.service.IProductService;
import com.wzn.service.ProductServiceImlp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    private IProductService service=new ProductServiceImlp();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      List<Product> lists= service.getLists();
      req.setAttribute("lists",lists);
      req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
    }
}
