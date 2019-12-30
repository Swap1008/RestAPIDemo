package products;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PATCHUpdateProducts {

	@Test
	public void updateProduct() {
		JSONObject product = new JSONObject();

		product.put("name", "Duracell - AAA Batteries (4-Pack)");
		product.put("type", "Battery");
		product.put("price", 20);
		product.put("shipping", 10);
		product.put("upc", "Batteries");
		product.put("description", "battery");
		product.put("manufacturer", "Duracell");
		product.put("model", "s232");
		product.put("url", "http://duracell.in");
		product.put("image", "b1.jpg");

		Response response = given().queryParam("id", "43900").header("Content-Type", "application/json")
				.body(product.toJSONString()).when().patch("http://localhost:3030/products/").then().assertThat()
				.statusCode(200).extract().response();
		System.out.println(response.getStatusLine());
	}
}
