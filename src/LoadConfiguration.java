import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LoadConfiguration {
		
	public static Configuration getConfig (String configPath){
		Configuration config = new Configuration();
	
		try {
		 
			File fXmlFile = new File(configPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
						
			NodeList paths = doc.getElementsByTagName("paths").item(0).getChildNodes();
			
			for (int i = 0; i< paths.getLength(); i++){
				Node nNode = paths.item(i);
				if ( "template_subject".equals(nNode.getNodeName())){
					config.setSubjectPath(nNode.getTextContent());
				}
				
				if ( "template_content".equals(nNode.getNodeName())){
					config.setContentPath(nNode.getTextContent());
				}
				
				if ( "csv".equals(nNode.getNodeName())){
					config.setCsvPath(nNode.getTextContent());
				}
			}
			
			config.setUser(doc.getElementsByTagName("user").item(0).getTextContent());
			config.setPassword(doc.getElementsByTagName("password").item(0).getTextContent());
			config.seteMail(doc.getElementsByTagName("email").item(0).getTextContent());
			
			NodeList properties = doc.getElementsByTagName("properties").item(0).getChildNodes();
			Map<String, String> propertiesMap = new HashMap<String, String>();
			
			for (int j = 0; j < properties.getLength(); j++){
				Node nNode = properties.item(j);
				if (!"#text".equals(nNode.getNodeName())){
					propertiesMap.put(nNode.getNodeName(), nNode.getTextContent());
				}
			}
			
			config.setProperties(propertiesMap);
			
		} catch (IOException ioe){
			System.out.println("Exception loading configuration file: " + ioe.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return config;
	}	
}
