import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.mail.Authenticator;
import javax.mail.*;

public class SMTPAuthenticator extends Authenticator{

	public PasswordAuthentication getPasswordAuthentication() {
		
		System.out.println("Enter your username and password:");
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader buff=new BufferedReader(reader);
		String username="" ,password="";
		try {
			System.out.println("Username:");
			username=buff.readLine();
			System.out.println("Password:");
			password=buff.readLine();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return new PasswordAuthentication(username,password);
	}
	
	

}
