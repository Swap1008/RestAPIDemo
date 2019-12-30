package demo;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class ResponseValidation {

	@Test
	public void tc001() {
		baseURI="http://localhost:3030";
		basePath="/stores";
		
				given()
				.when()
				.get("/12")
				.then()
				.statusCode(200)
				.body("services.name[0]",equalToIgnoringCase("Geek Squad Services") );
	}
}
