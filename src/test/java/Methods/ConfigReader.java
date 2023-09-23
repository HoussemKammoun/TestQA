package Methods;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	// Method to load the file Config.properties
	public static Properties getPropertyObject() throws IOException   {
		FileInputStream fp=new FileInputStream("./Config.properties");
		Properties prop=new Properties();
		prop.load(fp);
		return prop;
		
	}
	
	// Get the Endpoint of the API Get all Employees
	public static String URLGet() throws IOException {
		String link=getPropertyObject().getProperty("BaseURL")+ getPropertyObject().getProperty("RootGet");
		return link;
	}

	//  Get the Endpoint of the API Get a single user
	public static String URLGetSingle() throws IOException {
		String link=getPropertyObject().getProperty("BaseURL")+getPropertyObject().getProperty("RootGetSingle");
		return link ;
	}
	
	//  Get the Endpoint of the API Delete 
	public static String URLDelete() throws IOException {
		String link=getPropertyObject().getProperty("BaseURL")+getPropertyObject().getProperty("RootDelete");
		return link ;
	}
	
	//  Get the Endpoint of the API Post 
	public static String URLCreate() throws IOException {
		String a=getPropertyObject().getProperty("BaseURL")+getPropertyObject().getProperty("RootCreate");
		return a ;
	}
	
	// Get the Endpoint of the API update
	public static String URLUpdate() throws IOException {
		String a=getPropertyObject().getProperty("BaseURL")+getPropertyObject().getProperty("RootUpdate");
		return a ;
	}
	
	// Get the path of the body.json for Post method
	public static String BodyPostPath() throws IOException {
		return getPropertyObject().getProperty("Path_BodyFilePost");
		  
	}
	
	// Get the path of the body.json for update method
	public static String BodyPutPath() throws IOException {
		return getPropertyObject().getProperty("Path_BodyFileUpdate");
		  
	}
	
	
}
