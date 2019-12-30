package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class ResponseBodyDemo {
	@Test
	public void tc001() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		Response response=given()
				.when()
				.get("/Hyderabad")
				.then()
				.extract()
				.response();
		System.out.println(response.body().asString());
		System.out.println(response.body().asString().contains("haze"));
		
	}

}
