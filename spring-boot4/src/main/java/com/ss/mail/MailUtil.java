package com.ss.mail;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class MailUtil {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private FreeMarkerConfigurer confiurer;
	@Value("${spring.mail.username}")
	private String userName;
	
	public void sendMailSimple(){
		
		SimpleMailMessage  simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom(userName);
		simpleMessage.setSentDate(new Date());
		simpleMessage.setSubject("测试邮件信息");
		simpleMessage.setText("这是一份测试邮件");
		simpleMessage.setTo("327699388@qq.com");// 收件人
		//simpleMessage.setBcc("");// 密送人
		//simpleMessage.setCc("");// 抄送人
		mailSender.send(simpleMessage);
		System.out.println("发送邮件完成。。。。。");
	}
	
		public void sendMailFile() throws Exception{
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(userName);
			helper.setSentDate(new Date());
			helper.setSubject("测试附件邮件信息");
			helper.setText(getTempalte());
			helper.setTo("327699388@qq.com");// 收件人
			helper.addAttachment("测试文件.txt", new File("C:\\Users\\A_Ashao\\Desktop\\记事本.txt"));
			helper.addAttachment("学习笔记.docx", new File("E:\\java_doc\\git-repository\\a_shao_test\\java学习笔记二.docx"));
			mailSender.send(mimeMessage);
			System.out.println("发送邮件完成。。。。。");
		}
		
		public String getTempalte() throws Exception{
			Template template = confiurer.getConfiguration().getTemplate("my.ftl");
			StringWriter sw = new StringWriter();
			template.process(null, sw);
			System.out.println(sw.toString());
			return sw.toString();
		}
}
