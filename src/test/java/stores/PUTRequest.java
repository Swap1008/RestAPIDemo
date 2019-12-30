package stores;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PUTRequest extends BaseClass {

	@Test
	public void tc001() {
		JSONObject obj = new JSONObject();
		obj.put("name", "ABC");
		obj.put("type", "Retail");
		obj.put("address", "Pune");
		obj.put("address2", "ADDH");
		obj.put("city", "Pune");
		obj.put("state", "Maha");
		obj.put("zip", "411022");
		obj.put("lat", 0);
		obj.put("lng", 0);
		obj.put("hours", "string");
		Response response = PUTUpdateAllFields("", "", "", obj);

	}
}
