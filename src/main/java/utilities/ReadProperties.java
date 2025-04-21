package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ReadProperties {
	 static Properties probe = new Properties();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	setprop();
//String U = 	Readprop() ;
//System.out.println(U);
	}
public static String Readprop(String name) throws IOException {
	
	InputStream file = new FileInputStream("C:\\Users\\msuody\\Documents\\automation\\automation2\\TechTask2\\src\\main\\configfiles\\config.properties");
   probe.load(file);
   String TextName = probe.getProperty(name);
  System.out.println(probe.getProperty(TextName));
 // System.out.println(probe.getProperty("url"));
   return TextName; 
}

public static void setprop() throws IOException {
	
	OutputStream file = new FileOutputStream("C:\\Users\\msuody\\Documents\\automation\\automation2\\TechTask2\\src\\main\\configfiles\\config.properties");
   probe.setProperty("name", "mai");
   probe.store(file, "helooooooo");
 }
}
