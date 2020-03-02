package testrest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class post_delete_json extends BaseClass {

	@Test
	public void createPlaceAPI() {
		RestAssured.baseURI = prop.getProperty("hostname");
		Response res = null;

		
		res = given()
				 			.contentType(ContentType.JSON).log().all()
				 			.body(common_data.getcommondata())
				 	.when()
				 			.post(common_data.postcommon_json()) // call to common class
				 	.then()
				 		    .log().all()
				 			.extract().response();

		String reesponseis = res.asString();
		System.out.println(reesponseis);
		boolean status = res.asString().contains("OK");
		assertTrue(status);
		assertEquals(200, res.statusCode());

		//Extract the data and send 
		JsonPath js = new JsonPath(reesponseis);// json path for traversing the data
		String placeid = js.get("place_id");
		System.out.println("Place id is :" + placeid);
		
		given()
			.body("{" + "\"place_id\":\"" + placeid + "\"" + "}")
		.when()
			.post(common_data.postcommon_json()) //call the code in common class
		.then()
			.assertThat().statusCode(200);

	}

}