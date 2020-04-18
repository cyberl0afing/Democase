package com.example.web.servlet;

import com.example.domain.User;
import com.example.service.UserListService;
import com.example.service.impl.UserListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //调用service，获取userlist然后转发
        UserListService userListService = new UserListServiceImpl();
        List<User> users = userListService.findAll();
        req.setAttribute("users", users);
        req.setAttribute("user_count", users.size());
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
