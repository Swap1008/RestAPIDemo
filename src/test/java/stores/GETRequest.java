package stores;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GETRequest extends BaseClass {

	
	@Test(description = "Get All Stores")
	public void allStores() {
		Response response=GETAll("http://localhost:3030/stores");
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(description = "Get Store by id")
	public void storeById() {
		
		Response response=GETByValue("http://localhost:3030/stores", "id", "7");
		Assert.assertEquals(response.getStatusCode(), 200);
//		System.out.println(response.jsonPath().prettify());
				
	}
	
	
}
