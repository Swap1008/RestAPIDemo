package poc;

import org.testng.annotations.Test;

import config.BaseClass;
import io.restassured.response.Response;

public class DELETERequest extends BaseClass {

	@Test()
	public void tc004() {
		Response response = DELETERequest("stores/", "id", "8928","path");

		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}
}
