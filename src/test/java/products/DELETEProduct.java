package products;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DELETEProduct {

	@Test
	public void deleteProduct() {
		
		Response response=given()
		.queryParam("id", "346575")
		.when()
		.delete("http://localhost:3030/products/")
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		
		
	}
}
