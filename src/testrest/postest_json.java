package testrest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import files.common_data;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class postest_json extends BaseClass {

	@Test
	public void createPlaceAPI() {
		RestAssured.baseURI = prop.getProperty("hostname");
		Response res = null;

		
		res = given()
					.contentType(ContentType.JSON)
				 .body(common_data.getcommondata())
				 	.when()
				.post(common_data.postcommon_json()) // call to common class
				.then().extract().response();

		String reesponseis = res.asString();
		System.out.println(reesponseis);
		boolean status = res.asString().contains("OK");
		assertTrue(status);
		assertEquals(200, res.statusCode());

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