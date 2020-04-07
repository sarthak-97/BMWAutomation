package in.bmw.objectrepo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * 
 * @author sarthak-pc
 *
 */
public class GenerateLogFile {

	public void generateLogFile() throws IOException {
		
		
		Date date = new Date();
		
		
		  FileWriter file=new FileWriter("src/main/resources/log.txt");    
          file.write( "The execution date and time : " + date);  
          file.close();
          
          System.out.println(date);
		
		
		
	}
	
	
}
