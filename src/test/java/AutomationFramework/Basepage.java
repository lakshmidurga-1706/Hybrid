package AutomationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Basepage {
	
	public static Properties pro=null;
	public static FileInputStream fi=null;
	public static String path = "D:\\Practice_project\\Testing\\Property.properties";
	
	public static String getproperty(String prop) throws FileNotFoundException, IOException
	{
		pro=new Properties();
		fi = new FileInputStream(path);
		pro.load(fi);
		String output =pro.getProperty(prop);
		return output.toLowerCase();
	}
	
	
	

}
