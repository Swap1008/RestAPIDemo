package poc;

import org.testng.annotations.Test;

import config.BaseClass;
import io.restassured.response.Response;

public class GETRequest extends BaseClass{

	@Test()
	public void tc001() {
		Response response = GETRequest("/stores");

		System.out.println(response.jsonPath().prettify());
	}
}
