package testrest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
//import io.restassured.filter.log.RequestLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class addbook_post_delete_para_dynamic extends BaseClass {

	
	@Test(dataProvider="adddata",priority=0)
	public void addbook(String name,String idis) 
	{
		RestAssured.baseURI = prop.getProperty("hostname");
		common_data cd=new common_data();
		

		Response jadd = given()
				.header("Content-Type","application/json")
				.body(common_data.bookadd(name,idis)) // Here we sent the dynamic data
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
	
	@Test(dataProvider="deldata")
	public void deletebook(String isbn,String aisle) 
	{
		RestAssured.baseURI = prop.getProperty("hostname");
	
		         given()
			   	.body(getDeleteBody(isbn, aisle))
				.when()
					.post("/Library/DeleteBook.php")
				.then()
				    .assertThat()
				    .body("\"msg\"",equalTo("book is successfully deleted"));
	}
	
	
	@DataProvider(name="adddata")
	public Object[][] adddata() 
	{
		return new Object[][] { {"ace","1204"}, {"wew","1374"}, {"loe","3204"} };

	}

	
	@DataProvider(name="deldata")
	public Object[][] deldata() 
	{
		return new Object[][] { {"ace","1204"}, {"wee","1374"}, {"loe","3204"}};

	}
	
    public String getDeleteBody(String isbn, String aisle){
		String id = isbn + aisle;
		String s = "{\n" + 
				" \n" + 
				"\"ID\" : \""+id+"\"\n" + 
				" \n" + 
				"}";
		return s;
	} 

}
