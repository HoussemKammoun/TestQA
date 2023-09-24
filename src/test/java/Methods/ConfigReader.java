package Methods;
import java.io.FileInputStream;
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

	// Get the apikey
		public static String GetApiKey() throws IOException {
		String apikey=getPropertyObject().getProperty("apiKey");
		return apikey;
	}

	
	
}
