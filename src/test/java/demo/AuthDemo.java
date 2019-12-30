package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AuthDemo {

	@Test
	public void tc001() {
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		Response response=given()
				.auth()
				.basic("ToolsQA", "TestPassword")
		.when()
		.get()
		.then()
		.extract()
		.response();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.jsonPath().prettify());
	}
}
