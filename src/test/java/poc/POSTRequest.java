package poc;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import config.BaseClass;
import io.restassured.response.Response;

public class POSTRequest extends BaseClass {

	@Test()
	public void tc003() {

		JSONObject obj = new JSONObject();

		obj.put("name", "PortTechno");
		obj.put("type", "IT");
		obj.put("address", "Delhi");
		obj.put("address2", "Shopno 122");
		obj.put("city", "New Delhi");
		obj.put("state", "Delhi");
		obj.put("zip", "092323");
		obj.put("lat", 10);
		obj.put("lng", 430);
		obj.put("hours", "12");

		Response response = POSTRequest(obj, "stores/");

		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}
}
