package utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void main(String[] args) throws EmailException {
		
		System.out.println("test started");
		
		sendEmailNotification();
		
		System.out.println("email send");

	}

	public static void sendEmailNotification() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("forestice831@gmail.com", "tamannac90"));
		email.setSSLOnConnect(true);
		email.setFrom("fmdnizamul831@gmail.com");
		email.setSubject("Selenium Test Mail");
		email.setMsg("This is a test mail from selenium:-)");
		email.addTo("tushar_831@yahoo.com");
		email.send();
	}

}
