package poc;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import config.BaseClass;
import io.restassured.response.Response;

public class PUTRequest extends BaseClass {

	@Test
	public void tc006() {
		JSONObject obj = new JSONObject();

		obj.put("name", "PortTechno");
		obj.put("type", "ITQWERT");
		obj.put("address", "Dehradun");
		obj.put("address2", "Shopno 122");
		obj.put("city", "New Delhi");
		obj.put("state", "Delhi");
		obj.put("zip", "092323");
		obj.put("lat", 10);
		obj.put("lng", 430);
		obj.put("hours", "12");

		Response response = PUTRequest(obj, "stores/", "id", "8927");

		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());

	}

}
