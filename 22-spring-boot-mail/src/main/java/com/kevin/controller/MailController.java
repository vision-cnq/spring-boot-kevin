package com.kevin.controller;

import com.kevin.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/10/10
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 发送简单邮件
     * @return
     */
    @RequestMapping("/sendSimpleMail")
    public String sendSimpleMail(){
        String to = "caonanqing@yishouapp.com";
        String subject = "test";
        String content = "hello world";
        mailService.sendSimpleMail(subject,content,to);
        return "success";
    }

    /**
     * 发送Html格式邮件
     * @return
     */
    @RequestMapping("/sendHtmlMail")
    public String sendHtmlMail(){
        String to = "1021979964@qq.com";
        String subject = "test";
        String content = "hello world";
        mailService.sendHtmlMail(subject,content,to);
        return "success";
    }

    /**
     * 发送携带附件邮件
     * @return
     */
    @RequestMapping("/sendAttachmentsMail")
    public String sendAttachmentsMail(){
        String to = "1021979964@qq.com";
        String subject = "主题：带附件的邮件";
        String content = "有附件，请查收！";
        String filePath="C:\\Users\\caonanqing\\Desktop\\Test.txt";
        mailService.sendAttachmentsMail(subject, content, filePath, to);
        return "success";
    }

    /**
     * 发送模板邮件
     */
    @RequestMapping("/sendTemplateMail")
    public String sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("user", "Kevin");
        context.setVariable("web", "测试网");
        context.setVariable("company", "测试公司");
        context.setVariable("product","测试产品");
        String emailContent = templateEngine.process("index", context);
        String to = "1021979964@qq.com";
        String subject = "主题：模板邮件";
        mailService.sendHtmlMail(subject,emailContent,to);
        return "success";
    }



}
