package com.eshop.utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 发送邮件的工具类
 */
public class MailUtils {
	public static void sendMail(String email, String title, String emailMsg)
			throws AddressException, MessagingException {
		// 1.创建Properties对象，并设置邮件服务器的基本信息
		Properties props = new Properties();
		// 1.1 设置邮件传输协议SMTP
		props.setProperty("mail.transport.protocol", "SMTP");
		// 1.2 设置SMTP服务器地址，此处设置的是搜狐邮箱的SMTP服务器地址，如果是其他类型邮箱需要对应修改
		props.setProperty("mail.host", "smtp.163.com");
		// 1.3 设置SMTP服务器是否需要用户验证，需要验证设置为true
		props.setProperty("mail.smtp.auth", "true");
		// 1.4 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				// 设置QQ邮箱对应发件人的邮箱账户和密码，进行用户验证
				return new PasswordAuthentication("15201692782", "NPZRBMDCOQAODUIR");
			}
		};
		Session session = Session.getInstance(props, auth);
		// 2.创建一个Message，该对象相当于邮件内容
		Message message = new MimeMessage(session);
		// 设置发送人邮箱地址
		message.setFrom(new InternetAddress("15201692782@163.com"));
		// 设置发送方式与接收者
		message.setRecipient(RecipientType.TO, new InternetAddress(email)); 
		message.setSubject(title);
		// 设置邮件信息和编码格式
		message.setContent(emailMsg, "text/html;charset=utf-8");
		// 3.发送邮件
		Transport.send(message);
	}

}
