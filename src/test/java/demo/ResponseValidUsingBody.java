package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ResponseValidUsingBody {

	@Test
	public void tc001() {
		baseURI = "http://localhost:3030";
		basePath = "/stores";
		
		Response response=given()
		.when()
		.get("/12")
		.then()
		.statusCode(200)
		.extract()
		.response();
		
		JsonPath jp=response.jsonPath();
		
		List<String> str=jp.get("services.name");
		String s1=jp.get("services.name[0]");
		System.out.println(s1);
		Assert.assertTrue(str.contains("Best Buy Mobile"));
	}
}
