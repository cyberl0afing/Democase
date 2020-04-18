package com.example.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VcodeUtils {
    public static String VcodeGenerate(OutputStream os) {
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘制验证码
        Graphics g = image.getGraphics();//画笔类
        g.setColor(Color.pink);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.black);
        g.drawRect(0, 0, width - 1, height - 1);

        Random random = new Random();
        //int char_asc=random.nextInt(90-65+1)+65;
        String acode = "";
        for (int i = 0; i < 4; i++) {
            Character single = ((char) (random.nextInt(90 - 65 + 1) + 65));

            acode += single.toString();
        }//getAuthenticationCode
        g.drawString(acode, 20, 25);//draw the code
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acode;
    }
}
