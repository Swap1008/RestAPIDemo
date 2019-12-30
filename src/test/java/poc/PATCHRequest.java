package poc;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import config.BaseClass;
import io.restassured.response.Response;

public class PATCHRequest extends BaseClass{

	@Test()
	public void tc005() {
		JSONObject obj = new JSONObject();

		obj.put("name", "TechnoSys");

		Response response = PATCHRequest("stores/", obj, "id", "8927");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}
}
