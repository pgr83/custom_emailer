import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TemplateHelper {	
	
	 public String getTemplate(String path) {
		 
			BufferedReader br = null;
			String line = "";
			
			String result = "";

		 
			try {
		 
				br = new BufferedReader(new FileReader(path));
				while ((line = br.readLine()) != null) {
		 			    result = result + line + "\n";
				}
		 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}		
			return result;
		  }

}
