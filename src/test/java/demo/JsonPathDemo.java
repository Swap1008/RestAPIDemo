package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class JsonPathDemo {

	@Test
	public void tc001() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		Response response=given()
				.when()
				.get("/Pune")
				.then()
				.extract()
				.response();
		
		JsonPath jsPath=response.jsonPath();
		System.out.println(jsPath.get("City").toString().equalsIgnoreCase("pune"));
	}
}
