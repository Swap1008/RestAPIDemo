package stores;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class POSTRequest extends BaseClass{

	@Test
	public void tc001() {
		JSONObject obj=new JSONObject();
		String[][] services= {
				{"id","65"},
				
				
		};
		obj.put("name","ABC");
		obj.put("type","Retail");
		obj.put("address","Pune");
		obj.put("address2", "ADDH");
		obj.put("city", "Pune");
		obj.put( "state", "Maha");
		obj.put( "zip", "411022");
		obj.put( "lat", 0);
		obj.put("lng", 0);
		obj.put("hours", "string");
//		obj.put("services", services);
		
		  Response response=POSTAddRecord(obj, "http://localhost:3030/stores/");
		  Assert.assertEquals(response.getStatusCode(), 201);
		  System.out.println(response.getStatusCode());
		  System.out.println(response.getStatusLine());
	}
}
