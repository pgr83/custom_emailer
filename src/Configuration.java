import java.util.Collections;
import java.util.Map;


public class Configuration {
	private String user;
	private String password;
	private String eMail;	
	private String csvPath;
	private String subjectPath;
	private String contentPath;
	private Map<String, String> properties;

	public Configuration(String user, String password, String csvPath,
			String subjectPath, String contentPath,
			Map<String, String> properties) {
		super();
		this.user = user;
		this.password = password;
		this.csvPath = csvPath;
		this.subjectPath = subjectPath;
		this.contentPath = contentPath;
		this.properties = properties;
	}
	
	public Configuration() {
		this.user = "";
		this.password = "";
		this.csvPath = "";
		this.subjectPath = "";
		this.contentPath = "";
		this.properties = Collections.emptyMap();
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCsvPath() {
		return csvPath;
	}
	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}
	public String getSubjectPath() {
		return subjectPath;
	}
	public void setSubjectPath(String subjectPath) {
		this.subjectPath = subjectPath;
	}
	public String getContentPath() {
		return contentPath;
	}
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	public Map<String, String> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	
	
	@Override
	public String toString() {
		return "Configuration [user=" + user + ", password=" + password
				+ ", csvPath=" + csvPath + ", subjectPath=" + subjectPath
				+ ", contentPath=" + contentPath + ", properties=" + properties
				+ "]";
	}

}
