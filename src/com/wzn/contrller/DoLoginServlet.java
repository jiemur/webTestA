package com.wzn.contrller;

import com.wzn.pojo.User;
import com.wzn.service.IUserService;
import com.wzn.service.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoLoginServlet extends HttpServlet {
    private IUserService service=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        User u= service.getOne(username);
        if(u==null){
            resp.sendRedirect("register");
        }else{
            if(u.getPassword().equals(pwd)){
                resp.sendRedirect("list");
            }
        }


    }
}
