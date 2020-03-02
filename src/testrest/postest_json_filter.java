package testrest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class postest_json_filter extends BaseClass {
	
	@Test
	public void createPlaceAPI() {
		RestAssured.baseURI = prop.getProperty("hostname");

				 //below will print the log for request and body together
				 /* RestAssured.given()
				 			.contentType(ContentType.JSON)
				 			.body(common_data.getcommondata())
				 			.filter(new RequestLoggingFilter(requestcapture))
				 			.filter(new ResponseLoggingFilter(responsecapture))
				 	.when()
				 			.post(common_data.postcommon_json()); // call to common class
				 		 	 System.out.println(requestwriter.toString());
				 		     System.out.println(responsewriter.toString());*/
		
				/* this will come in picture when error occurs 400 or 500*/
				/* RestAssured
				 .given()
				 	.contentType(ContentType.JSON)
		 			.body(common_data.getcommondata())
		 			.filter(new ErrorLoggingFilter(error_responsecapture))
		 		.when()
		 			.post(common_data.postcommon_json());
		 			System.out.println(error_responsewriter.toString());*/
		 			
		      
				 		 	 


	}

}