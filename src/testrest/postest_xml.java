package testrest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import files.common_data;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class postest_xml extends BaseClass {

	@Test
	public void createPlaceAPI() throws IOException {
		RestAssured.baseURI = prop.getProperty("hostname");
		Response res = null;
		common_data cd=new common_data();

		String converted=common_data.xmlgetconverstring(System.getProperty("user.dir") + "\\src\\files\\xmlget.xml");
		//System.out.println(converted);	
		
		res = given()
				 .contentType(ContentType.XML)
				 .body(converted) // send the converted xml to string
				 .when()
				 .post(common_data.postcommon_xml()) // call to common class
				 .then().extract().response();
				
		XmlPath x=cd.rawtoxml(res);// the outout is again converted to string
		System.out.println(x.getString("response.scope")); // type x dot and u wll get the different type
		System.out.println(x.getString("response.reference"));
		
		/*For list
		List<String> listtest=x.getList("a.b.c.d");
		for (String string : listtest) {
			System.out.println(string);
		}*/
		
	
		
	}

}