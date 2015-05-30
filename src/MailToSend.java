
public class MailToSend {
	public String eMail;
	public String ceoName;
	public String companyName;
	
	public MailToSend(String email, String ceoname, String companyname){
		eMail = email;
		ceoName = ceoname;
		companyName = companyname;
	}
	
	public void setEmail (String email){
		eMail = email;
	}
	
	public void setCeoname (String ceoname){
		ceoName = ceoname;		
	}
	
	public void setCompanyname (String companyname){
		companyName = companyname;
	}
	
	public String toString (){
		return "Company name: "+companyName+"\n CEO name: "+ceoName+"\n Email: "+eMail;
	}
}
        