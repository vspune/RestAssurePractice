package testrest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class common_data {

	public static String postcommon_json() {
		String poststring = "/maps/api/place/add/json?key=qaclick123";
		return poststring;
	}

	public static String postcommon_xml() {
		String poststring = "/maps/api/place/add/xml?key=qaclick123";
		return poststring;
	}

	public XmlPath rawtoxml(Response res) {
		String responseis = res.asString();
		XmlPath x = new XmlPath(responseis);
		return x;
	}

	public JsonPath rawToJson(Response j) {
		String respon = j.asString();
		JsonPath x = new JsonPath(respon);
		return x;

	}

	public static String getcommondata() {
		String requestbody = "{\n" + "\"location\":{ " + "\"lat\" : -38.383494," + "\"lng\" : 33.427362 " + "},"
				+ "\"accuracy\":50, " + "\"name\":\"VSPune\", " + "\"phone_number\":\"(+91) 123 456 7890\", "
				+ "\"address\" : \"29, side layout, cohen 09\"," + "\"types\": [\"shoe park\",\"shop\"],"
				+ "\"website\" : \"http://google.com\", " + "\"language\" : \"French-IN\"" + "}";
		return requestbody;
	}

	public static String converstring(String path) throws IOException // this is required for converting to string
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	public String addbook() {
		String addbook = "/Library/Addbook.php/";
		return addbook;
	}

	/*
	 * try { res = given() .contentType(ContentType.JSON) .body("{\n" +
	 * "\"location\":{ \n" + "\"lat\" : -38.383494,\n" + "\"lng\" : 33.427362 \n" +
	 * "},\n" + "\"accuracy\":50,\n" + "\"name\":\"VSPune\",\n" +
	 * "\"phone_number\":\"(+91) 123 456 7890\",\n" +
	 * "\"address\" : \"29, side layout, cohen 09\",\n" +
	 * "\"types\": [\"shoe park\",\"shop\"],\n" +
	 * "\"website\" : \"http://google.com\",\n" + "\"language\" : \"French-IN\"" +
	 * "}") .when() .post("/maps/api/place/add/json?key=qaclick123");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 */

	public static String bookadd(String ID, String name) {
		String addbook = "{\r\n\"name\":\"Blackie1\",\r\n\"isbn\":\"" + ID + "\",\r\n\"aisle\":\"" + name
				+ "\",\r\n\"author\":\"VS Book\"\r\n}";
		return addbook;
	}

}
