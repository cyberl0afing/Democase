package com.example.web.servlet;

import com.example.utils.VcodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/vcode")
public class VcodeServlet extends HttpServlet {
    //返回验证码对象

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证码接口
        resp.setContentType(this.getServletContext().getMimeType(".jpg") + ";charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        String vcode = VcodeUtils.VcodeGenerate(resp.getOutputStream());
        session.setAttribute("vcode_session", vcode);

    }
}
