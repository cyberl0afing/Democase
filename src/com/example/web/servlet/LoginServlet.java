package com.example.web.servlet;

import com.example.domain.Admin;
import com.example.service.LoginService;
import com.example.service.impl.LoginServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        //做验证码检查
        String vcode_session = (String) req.getSession().getAttribute("vcode_session");
        req.getSession().removeAttribute("vcode_session");
        String vcode_client = req.getParameter("verifycode");

        if (vcode_session == null || (!vcode_session.equalsIgnoreCase(vcode_client))) {
            //验证码错误或空，跳转回登录页面，并输出错误信息
            req.setAttribute("login_error", "验证码错误");
            //设置错误信息
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            //跳转到登录页面
        }
        //接下来进行账户密码校验
        Map<String, String[]> parmMap = req.getParameterMap();
        Admin loginAdmin = new Admin();
        try {
            BeanUtils.populate(loginAdmin, parmMap);
            System.out.println(loginAdmin);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }//进行登录对象

        LoginService loginService = new LoginServiceImpl();
        if ((loginAdmin = loginService.login(loginAdmin)) != null) {
            //跳转到管理页面
            req.getSession().setAttribute("username", loginAdmin.getUsername());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }//登录成功
        else {
            req.setAttribute("login_error", "账户名或密码错误");
            //设置错误信息
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            //跳转到登录页面
        }

    }
}
