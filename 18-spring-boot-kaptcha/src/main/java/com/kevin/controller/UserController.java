package com.kevin.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/17
 */
@Controller
public class UserController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping("/defaultKaptcha")
    @ResponseBody
    public void setDefaultKaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        byte[] kaptchaJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String text = defaultKaptcha.createText();
            request.getSession().setAttribute("vrifyCode",text);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte数组中
            BufferedImage image = defaultKaptcha.createImage(text);
            ImageIO.write(image,"jpg",jpegOutputStream);
        } catch (Exception e) {
            try {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        kaptchaJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");

        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(kaptchaJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView vrifyCode(HttpSession httpSession, String vrifyCode) {

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        String code = (String)httpSession.getAttribute("vrifyCode");
        if(code.equals(vrifyCode)) {
            view.addObject("msg","登录成功");
        } else {
            view.addObject("msg","输入的验证码有误");
        }
        return view;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/main")
    public String main() {
        return "index";
    }

}
