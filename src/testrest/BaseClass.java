package testrest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class BaseClass {

	Properties prop=new Properties();
	
	@BeforeTest()
	public void init() throws IOException
		{
		String config_path = System.getProperty("user.dir") + "\\src\\files\\env.properties";
		FileInputStream fis=new FileInputStream(config_path);
		prop.load(fis);
		prop.get("hostname");

		}	
}
