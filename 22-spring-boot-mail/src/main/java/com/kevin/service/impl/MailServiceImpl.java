package com.kevin.service.impl;

import com.kevin.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/10/10
 */
@Service
@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendSimpleMail(String subject, String content, String... to) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
            System.out.println("发送简单邮件成功...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void sendHtmlMail(String subject, String content, String... to) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
            System.out.println("html邮件发送成功...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendAttachmentsMail(String subject, String content, String filePath, String... to) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName,file);
            mailSender.send(message);
            System.out.println("携带附件的邮件发送成功...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
