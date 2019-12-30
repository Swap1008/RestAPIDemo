package demo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PathParametersDemo {
	@Test
	public void tc001() {
		baseURI="http://localhost:3030";
		basePath="/stores";
		
		Response response=given()
				.pathParam("id", "4")
				.when()
				.get("/{id}")
				.then()
				.extract()
				.response();
		System.out.println(response.getStatusCode());
				System.out.println(response.jsonPath().prettify());
	}

}
