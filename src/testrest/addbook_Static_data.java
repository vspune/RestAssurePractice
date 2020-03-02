package testrest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
//import io.restassured.filter.log.RequestLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class addbook_Static_data extends BaseClass {

	
	@Test()
	public void addbook() throws IOException 
	{
		RestAssured.baseURI = prop.getProperty("hostname");
		common_data cd=new common_data();
	
		Response jadd = given()
				.header("Content-Type","application/json")
			//	.body(testconverstring(System.getProperty("user.dir") + "\\src\\files\\staticdata.json"))
	        	 .body(common_data.converstring(System.getProperty("user.dir") + "\\src\\files\\staticdata.json"))
				//.filter(new RequestLoggingFilter(requestcapture))
	        	 
				//.filter(new ResponseLoggingFilter(responsecapture))
				.when()
						.post("/Library/Addbook.php/")
				.then()
						.extract().response();
				//System.out.println(requestwriter.toString());
				//System.out.println(responsewriter.toString());
			//	System.out.println(jadd.getBody().asString());
				
				JsonPath js=cd.rawToJson(jadd);
				
				String id=js.get("ID");
				System.out.println(id);
				
			 /*   given()
				.body("{\r\n\"ID\":\""+id+"\"\r\n}")
				.when()
					.post("/Library/DeleteBook.php")
				.then()
				    .assertThat()
				    .body("\"msg\"",equalTo("Delete Book operation failed, looks like the book doesnt exists"));*/
	}
	
//	public static String testconverstring(String path) throws IOException // this is required for converting to string
//	{
//		return new String(Files.readAllBytes(Paths.get(path)));
//	}


	
	
}
