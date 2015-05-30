import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToMailToSendList {
	 
	  public List<MailToSend> getList(String path) {
	 
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		
		List<MailToSend> list = new ArrayList<MailToSend>();		
	 
		try {
	 
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
	 			    
				String[] ceo = line.split(cvsSplitBy);
				
				try {
					list.add(new MailToSend(ceo[2], ceo[1], ceo[0]));
				} catch (ArrayIndexOutOfBoundsException out){
					System.out.println("Could not parse: "+ line);
				}
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
		return list;
	  }
}