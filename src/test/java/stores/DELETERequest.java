package stores;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DELETERequest extends BaseClass {

	@Test
	public void tc001() {
		
		RestAssured.baseURI="http://localhost:3030/stores";

		Response response=given()
		.when()
		.delete("/10")
		.then()
		.extract()
		.response();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println();
	}
}
