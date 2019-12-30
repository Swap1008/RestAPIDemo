package products;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;



import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class POSTAddProduct {

	@Test
	public void addSingleProduct() {
		
		JSONObject product=new JSONObject();
		
		product.put("name", "Bottles");
		product.put("type","Tupperware");
		product.put("price", 20);
		product.put("shipping",10);
		product.put("upc","UPCBottle");
		product.put("description","Used to carry water");
		product.put("manufacturer", "ABCfdshf");
		product.put("model","s232");
		product.put("url","http://bottles.in");
		product.put("image","b1.jpg");	
		
		
		Response response=given()
				.header("Content-Type","application/json")
				.body(product.toJSONString())
				.when()
				.post("http://localhost:3030/products")
				.then()
				.assertThat()
				.statusCode(201)
				.extract()
				.response()
				;
		System.out.println(response.getStatusLine());
		
	}

}
