package stores;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class BaseClass {

	/***
	 * GET Request: To Get all the records
	 * 
	 * @param url
	 * @return response
	 * @author Swapnil Naidu
	 */
	public  Response GETAll(String url) {
		return given().when().get(url).then().assertThat().statusCode(200).extract().response();
	}

	/***
	 * GET Request: To get specific records by parameterName and parameterValue
	 * 
	 * @param {@code String url} 
	 * @param {@code String parameterName}
	 * @param {@code parameterVal}
	 * @return response
	 * @author Swapnil Naidu
	 */
	public  Response GETByValue(String url, String parameterName, String parameterVal) {
		return given().queryParam(parameterName, parameterVal).when().get(url).then().assertThat().statusCode(200)
				.extract().response();
	}

	/***
	 * POST Request: Add a new record
	 * 
	 * @param Jsonobj
	 * @param url
	 * @return response
	 * @author Swapnil Naidu
	 */
	public Response POSTAddRecord(JSONObject obj, String url) {
		return given().header("Content-Type", "application/json").body(obj.toJSONString()).when().post(url).then()
				.assertThat().statusCode(201).extract().response();
	}

	/***
	 * PATCH Request : To update some or all the fields of the record.
	 * 
	 * @param {@code JSONObject} obj
	 * @param {@code String url}
	 * @param parameterName
	 * @param parameterValue
	 * @return response
	 * @author Swapnil Naidu
	 */
	public Response PATCHUpdateRecord(JSONObject obj, String url, String parameterName, String parameterValue) {
		return given().queryParam(parameterName, parameterValue).header("Content-Type", "application/json")
				.body(obj.toJSONString()).when().patch(url).then().assertThat().statusCode(200).extract().response();

	}
	
	/***
	 * DELETE Request: To delete a specific record based on the parameterName and parameterValue
	 * @param url
	 * @param parameterName
	 * @param parameterValue
	 * @return response
	 * @author Swapnil Naidu
	 */

	public Response DELETERecord(String url,String parameterName,String parameterValue) {
		return given()
		.queryParam(parameterName, parameterValue)
		.when()
		.delete(url)
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
	}
	
	/***
	 * PUT Request: To update all the fields of the record
	 * @param url
	 * @param parameterName
	 * @param parameterValue
	 * @param obj
	 * @return response
	 * @author Swapnil Naidu
	 */
	public Response PUTUpdateAllFields(String url,String parameterName,String parameterValue,JSONObject obj) {
		return given()
		.queryParam(parameterName, parameterValue)
		.header("Content-Type", "application/json")
		.body(obj.toJSONString())
		.when()
		.put(url)
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		
	}
}
