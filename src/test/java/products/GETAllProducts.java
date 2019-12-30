package products;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class GETAllProducts {

	@Test(description = "List of All Products")
	public void allProducts001() {
		Response response = given().when().get("http://localhost:3030/products").then().contentType("application/json")
				.extract().response();

		Assert.assertEquals(response.getStatusCode(), 200);
//		System.out.println(response.jsonPath().prettify());
	}

	@Test(description = "Get Product by Id")
	public void productById() {
		Response response = given().queryParam("id", "43900").when().get("http://localhost:3030/products/").then()
				.contentType("application/json").extract().response();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(description = "Check the product by name")
	public void checkProductName() {
		Response response=given()
						.queryParam("id", "43900")
						.get("http://localhost:3030/products/")
						.then()
						.assertThat()
						.statusCode(200)
						.extract()
						.response()	;
		
		String res=response.jsonPath().getString("data.name");
		Assert.assertEquals(res, "[Duracell - AAA Batteries (4-Pack)]");	
//		System.out.println(response.getBody().asString());
//		ResponseBody resBody=response.getBody();
//		System.out.println(resBody.asString().contains(res));
	}
}
