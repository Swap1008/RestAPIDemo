package poc;

import org.testng.annotations.Test;

import config.BaseClass;
import io.restassured.response.Response;

public class GETRequestById extends BaseClass {

	@Test()
	public void tc002() {
		Response response = GETRequest("stores/", "id", "4","path");
		System.out.println(response.jsonPath().prettify());
	}
}
