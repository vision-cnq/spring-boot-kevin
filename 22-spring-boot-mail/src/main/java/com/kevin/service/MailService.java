package com.kevin.service;

/**
 * @author caonanqing
 * @version 1.0
 * @description     邮件发送方式
 * @createDate 2019/10/10
 */
public interface MailService {

    /**
     * 发送简单邮件
     * @param subject   主题
     * @param content   内容
     * @param to    收件人
     */
    void sendSimpleMail(String subject, String content, String... to);

    /**
     * 发送Html邮件
     * @param subject   主题
     * @param content   内容
     * @param to    收件人
     */
    void sendHtmlMail(String subject, String content, String... to);

    /**
     * 发送携带附件邮件
     * @param subject   主题
     * @param content   内容
     * @param filePath  附件
     * @param to    收件人
     */
    void sendAttachmentsMail(String subject, String content, String filePath, String... to);

}
