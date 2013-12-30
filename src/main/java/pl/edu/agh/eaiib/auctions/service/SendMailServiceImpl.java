package pl.edu.agh.eaiib.auctions.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailServiceImpl implements SendMailService {

    private String host = "smtp.gmail.com";

    private String user = null;

    private String passwd = null;

    private boolean demo = false;

    private boolean starttls = false;

    private boolean auth = true;

    private String port = "587";

    @Override
    public void sendMail(String from, String to, String messageText) {
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.auth", Boolean.toString(auth));
        properties.put("mail.smtp.starttls.enable", Boolean.toString(starttls));
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        if ( demo ) {
            return;
        }
        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, passwd);
            }
        });

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

    public void setStarttls(boolean starttls) {
        this.starttls = starttls;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDemo(boolean demo) {
        this.demo = demo;
    }

}
