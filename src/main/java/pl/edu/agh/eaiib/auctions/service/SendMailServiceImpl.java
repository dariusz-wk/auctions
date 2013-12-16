package pl.edu.agh.eaiib.auctions.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailServiceImpl implements SendMailService {

	private String host;
	private String user = null;
	private String passwd = null;

	@Override
	public void sendMail(String from, String to, String messageText) {
		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		if (user != null)
			properties.setProperty("mail.user", user);
		if (passwd != null)
			properties.setProperty("mail.password", passwd);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Auction API!");

			// Send the actual HTML message, as big as you like
			message.setContent(messageText, "text/html");

			// Send message
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setUser(String user) {
		this.user = user;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
