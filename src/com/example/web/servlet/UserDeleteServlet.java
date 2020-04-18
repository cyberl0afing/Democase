package com.example.web.servlet;

import com.example.service.UserDeleteService;
import com.example.service.impl.UserDeleteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userdelete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String user_id = req.getParameter("id");
        System.out.println(user_id);
        System.out.println("hello");
        UserDeleteServiceImpl userDeleteService = new UserDeleteServiceImpl();
        String[] ids = {user_id};
        System.out.println(ids[0]);
        List<String> delete_user_ids = userDeleteService.delete(ids);
        //返回删除信息
//        req.setAttribute("delete_user_ids",delete_user_ids);
//        req.getRequestDispatcher("/userlist").forward(req,resp);
        System.out.println(req.getContextPath());
        resp.sendRedirect(req.getContextPath() + "/userlist");
    }
}
