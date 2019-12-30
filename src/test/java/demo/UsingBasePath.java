package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsingBasePath {

	@Test
	public void tc001() {
		baseURI="http://localhost:3030";
		basePath="/stores";
		
		Response response=given()
				.when()
				.get("/12")
				.then()
				.extract()
				.response();
		System.out.println(response.getStatusLine());
		
		System.out.println(response.jsonPath().prettify());
	}
}
