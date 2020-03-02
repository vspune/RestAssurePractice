package testrest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class gettest_json extends BaseClass {
	
	@Test(priority=0)
	public void getcase() {
		//Use the below for path param
		    RequestSpecification httpRequest = RestAssured.given();
		   // httpRequest.log().all();
			RestAssured.given().param("location", "-33.870775,151.199025")
							   .param("radius", "5000")
							   .param("key", "AIzaSyCE7yUJ6qm6_jw4BlW1relEZDgBr7-b7co");
			
		    Response res=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/json");
		    
		    String contenttype=res.header("content-type");
			Assert.assertEquals(contenttype, "application/json; charset=UTF-8");
		  		    
			String server=res.header("server");
			Assert.assertEquals(server, "scaffolding on HTTPServer2");
			
			/*String responseBody=res.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
			Headers hd=res.headers();
			for(Header header:hd)
			{
				System.out.println("Key is : " + header.getName() + " Value is :" + header.getValue());
							
			}*/
			
/*	//Passing values using Query Parameters
		given().param("location", "-33.870775,151.199025")
				.param("radius", "5000")
				.param("key", "AIzaSyCE7yUJ6qm6_jw4BlW1relEZDgBr7-b7co")
		.when()
				.get("/maps/api/place/nearbysearch/json")
		.then()
				.assertThat().body("status",equalTo("REQUEST_DENIED"))
				.and()
				.contentType(ContentType.JSON);
			.body("abcd",hasitems());*/
	}


}