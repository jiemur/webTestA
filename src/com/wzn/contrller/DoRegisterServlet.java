package com.wzn.contrller;

import com.wzn.pojo.User;
import com.wzn.service.IUserService;
import com.wzn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoRegisterServlet extends HttpServlet {
    private IUserService service=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username= req.getParameter("username");
        String pwd= req.getParameter("pwd");
       String pwds= req.getParameter("pwds");
        String tele= req.getParameter("tele");
        User u=new User();
        u.setUsername(username);
        u.setPassword(pwd);
        u.setTele(tele);

        if(pwd.equals(pwds)){
            service.insert(u);
            resp.sendRedirect("login");
        }
    }
}
