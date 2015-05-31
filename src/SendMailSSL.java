import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailSSL {
	
	public static String sendMail(MailToSend mailtosend, final String user, final String passwd, String originEmailAdress, String subject, String template, Configuration conf){
		String statusMessage = "\n---\n"+mailtosend.toString()+"\n Status: ";
		String status = "error";
		
		if (mailtosend.ceoName.isEmpty() || mailtosend.eMail.isEmpty() || mailtosend.companyName.isEmpty()){
			status = "ERROR, check email adress, CEO name and company name";
			return statusMessage + status;
		}
		
		if (user.isEmpty() || passwd.isEmpty()){
			status = "ERROR, check user and password";
			return statusMessage + status;
		} 
		
		Properties props = new Properties();
		
	    for (Map.Entry<String, String> entry : conf.getProperties().entrySet()) {
	        props.put(entry.getKey().toString(), entry.getValue());
	    }
				
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user,passwd);
					}
				});
		try {
			subject = subject.replace("{ceoname}", mailtosend.ceoName);
			subject = subject.replace("\n", "");
			subject = subject.replace("{companyname}", mailtosend.companyName);
			
			template = template.replace("{companyname}", mailtosend.companyName);
			template = template.replace("{ceoname}", mailtosend.ceoName);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(originEmailAdress));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailtosend.eMail));
			message.setSubject(subject);
			message.setContent(template, "text/html");
 
			Transport.send(message);
  
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
		return statusMessage+" OK";
	}
}