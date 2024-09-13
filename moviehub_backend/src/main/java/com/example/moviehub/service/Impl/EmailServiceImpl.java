package com.example.moviehub.service.Impl;

import com.example.moviehub.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public void sendMail(String receiver, String subject, String content) {


        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(receiver);
            message.setSubject(subject);
            message.setText(content);
            javaMailSender.send(message);
        }catch (Exception e){
            log.error("sendMail exception: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }



    }

    public void sendHtmlMail(String receiver, String subject, String operation, String verificationCode) {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(receiver);
            message.setSubject(subject);

            Context context = new Context();
            context.setVariable("verificationCode", verificationCode);
            context.setVariable("operation", operation);

            String process = templateEngine.process("VerificationCodeTemplate", context);
            mimeMessageHelper.setText(process, true);
            javaMailSender.send(message);

        }catch (Exception e){
            log.error("sendMail exception: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
