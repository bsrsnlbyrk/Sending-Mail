import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class SendMail {
	

	public static void main(String[] args) throws Exception{
		
		Properties myProp=new Properties();
		
		try {
			myProp.put("mail.smtp.host", "smtp.gmail.com");
			myProp.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			myProp.put("mail.smtp.auth","true");
			myProp.put("mail.smtp.port", "465");
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
			System.exit(0);
		}
		
		Session mySession=Session.getInstance(myProp, new SMTPAuthenticator());
		try {
		Message myMessage=new MimeMessage(mySession);
		Address myFrom=new InternetAddress("blabla@gmail.com","Blabla");
		Address myTo=new InternetAddress("anonymous@gmail.com","Anonymous");
		
		myMessage.setFrom(myFrom);
		myMessage.setRecipient(Message.RecipientType.TO,myTo);
		
		myMessage.setSubject("Test Mail");
		String content=new String("<html>"+"<head>"+"<title>Test</title>"
		+"</head>"+"<body><font color='#336669\' size=11"+"Hello World!"+"</font>"
		+"</body>"+"</html>");
		
		myMessage.setContent(content,"text/html;charset=UTF-8");
		Transport.send(myMessage);
		System.out.println("The message is sent.");
		}
		catch(Exception ex) {
			System.out.println("The message could not send!");
			System.out.println(ex.getMessage());
		}

	}

}
