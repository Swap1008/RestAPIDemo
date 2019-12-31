package demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import config.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class JsonPathExpression extends BaseClass {

	@Test(invocationCount = 0)
	public void tc001() {
		Response response = GETRequest("/stores");

//		System.out.println(response.jsonPath().prettify());
	}

	@Test(invocationCount = 0)
	public void tc002() {
		Response response = GETRequest("stores/", "id", "4","path");
//		System.out.println(response.jsonPath().prettify());
	}

	@Test(invocationCount = 0)
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
	
	@Test(invocationCount = 0)
	public void tc004() {
		Response response=DELETERequest("stores/", "id","8928","path");
		
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}
	
	@Test(invocationCount = 0)
	public void tc005() {
		JSONObject obj = new JSONObject();

		obj.put("name", "TechnoSys");

		
		Response response=PATCHRequest("stores/", obj, "id", "8927","path");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}
	
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
		
		Response response=PUTRequest(obj, "stores/","id", "8927","path");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
	}
}
