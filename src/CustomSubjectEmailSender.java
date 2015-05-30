import java.util.List;


public class CustomSubjectEmailSender {
	
	public static void main(String[] args) {
		
		String user = args[0];
		String passwd = args[1];
		String originEmail = args[2];
		String csvPath = args[3];
		String subjectPath = args[4];
		String templatePath = args[5];
		
		CsvToMailToSendList parser = new CsvToMailToSendList();	
		TemplateHelper templategetter = new TemplateHelper();
				
		List<MailToSend> list = parser.getList(csvPath);
		String template = templategetter.getTemplate(templatePath);
		String subject = templategetter.getTemplate(subjectPath);			
		
		for (int i=0; i<list.size(); i++){
			String result = SendMailSSL.sendMail(list.get(i), user, passwd, originEmail, subject, template);
			System.out.println(result);
		}
	}

}
