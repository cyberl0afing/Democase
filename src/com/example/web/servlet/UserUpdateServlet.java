package com.example.web.servlet;

import com.example.domain.User;
import com.example.service.impl.UserUpdateserviceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        进行参数回显
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //设置响应
        String update_user_id = req.getParameter("id");
        User user = new UserUpdateserviceImpl().find(update_user_id);
        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/update.jsp").forward(req, resp);//请求转发到用户更新的表单
        } else {
            //显示错误信息
            req.setAttribute("error_info", "没有找到相关对象");
            req.getRequestDispatcher("/userlist").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      进行提交请求的处理
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");


        Map<String, String[]> userMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, userMap);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error_info", "更新用户信息失败");
            req.getRequestDispatcher("/userlist").forward(req, resp);
        }
        System.out.println(user);

        int count = new UserUpdateserviceImpl().update(user);
        System.out.println(count);
        if (count == 1) {
            resp.sendRedirect(req.getContextPath() + "/userlist");
            //转发到userlist
        } else {
            resp.sendRedirect(req.getContextPath() + "/userlist?error=update_fail");
            //这样等于推post请求
        }
    }
}
