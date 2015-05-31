import java.util.List;


public class CustomSubjectEmailSender {
	
	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		
		if ( args.length > 0){
			conf = LoadConfiguration.getConfig(args[0]);
		} else {
			conf = LoadConfiguration.getConfig("C:/temp/config.xml");
		}
		
		String user = conf.getUser();
		String passwd = conf.getPassword();
		String originEmail = conf.geteMail();
		String csvPath = conf.getCsvPath();
		String subjectPath = conf.getSubjectPath();
		String templatePath = conf.getContentPath();
		
		CsvToMailToSendList parser = new CsvToMailToSendList();	
		TemplateHelper templategetter = new TemplateHelper();
				
		List<MailToSend> list = parser.getList(csvPath);
		String template = templategetter.getTemplate(templatePath);
		String subject = templategetter.getTemplate(subjectPath);			
		
		for (int i=0; i<list.size(); i++){
			String result = SendMailSSL.sendMail(list.get(i), user, passwd, originEmail, subject, template, conf);
			System.out.println(result);
		}
	}

}
