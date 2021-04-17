package loginUI;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import com.email.durgesh.Email;

public class EmailSending {

	public static String sendMail(String recepient) throws UnsupportedEncodingException, MessagingException {
		
		Random rnd = new Random();
	    String string = String.valueOf(rnd.nextInt(999999+10000));
		
		Email email = new Email("yourmail@email.com", "yourPassword");
		email.setFrom("yourmail@email.com", "Title");
		email.setSubject("OTP verification");
		email.setContent("<h1>OTP : " + string + "</h1>", "text/html");
		email.addRecipient(recepient);
		email.send();
		System.out.println("Email sent");	
		return string;
		
	}

}
