package testrest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	static Properties prop=new Properties();
	public static StringWriter requestwriter;
	public static PrintStream  requestcapture;
	public static StringWriter responsewriter;
	public static PrintStream  responsecapture;	
	public static StringWriter error_responsewriter;
	public static PrintStream  error_responsecapture;	
	
	@BeforeClass()
	public static void init() throws IOException
		{
		String config_path = System.getProperty("user.dir") + "\\src\\files\\env.properties";
		FileInputStream fis=new FileInputStream(config_path);
		prop.load(fis);
		prop.get("hostname");
	 }	
	
	@BeforeTest()
	 public void requestwritetoconsole()
    {
    	requestwriter = new StringWriter();
    	requestcapture = new PrintStream(new WriterOutputStream(requestwriter),true);//write object
    	
    	responsewriter = new StringWriter();
    	responsecapture = new PrintStream(new WriterOutputStream(responsewriter),true);//write object
    	
    	error_responsewriter = new StringWriter();
    	error_responsecapture = new PrintStream(new WriterOutputStream(error_responsewriter),true);//write object
     }
	
//	public static void logfile() throws FileNotFoundException
//	{
//		PrintStream fileOutPutStream = new PrintStream(new File(System.getProperty("user.dir") + "\\src\\files\\env.properties"));	
//		RestAssured.config=RestAssured.config.logConfig(new LogConfig().defaultStream(fileOutPutStream)); 
//	
//	}
 
}
