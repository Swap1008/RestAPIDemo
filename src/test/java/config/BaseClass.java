package config;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class BaseClass {

	FileInputStream propFile;
	Properties configProp;

/***
 *  
 */
	public BaseClass() {
		configProp = new Properties();
		try {
			propFile = new FileInputStream(System.getProperty("user.dir") + "\\Properties\\configuration.properties");
			configProp.load(propFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		baseURI = configProp.getProperty("baseUrl");
	}

	/***
	 * GET Request: Get all the Data using this method.Pass the url path on which
	 * the Request has to be fired. For Ex :"stores/"
	 * 
	 * @param {@code String urlPath}
	 * @return {@code Response response}
	 * @author Swapnil Naidu
	 */

	public Response GETRequest(String urlPath) {

		return given().when().get(urlPath).then().extract().response();

	}

	/***
	 * GET Request: Get data of specific record based on some parameter name and
	 * parameter value. Ex: {@link http://localhost:3030/stores/4}, where id=4,its a
	 * path parameter
	 * 
	 * @param {@code String urlPath}
	 * @param {@code String parameterName}
	 * @param {@code String parameterValue}
	 * @return Response
	 * @author Swapnil Naidu
	 */
	public Response GETRequest(String urlPath, String parameterName, String parameterValue) {

		return given().param(parameterName, parameterValue).when().get(urlPath).then().extract().response();

	}

	/***
	 * POST Request: To Add a new record using JsonObject.
	 * 
	 * @param {@code  jsonObject}
	 * @param {@code urlPath}
	 * @return Response
	 * @author Swapnil Naidu
	 */

	public Response POSTRequest(JSONObject jsonObj, String urlPath) {
		return given().header("Content-Type", "application/json").body(jsonObj.toJSONString()).when().post(urlPath)
				.then().extract().response();
	}

	/***
	 * PUT Request: To Update entire record based on particular parameterName and
	 * respective parameterValue.Complete payload/jsonObject has to be sent.
	 * 
	 * @param jsonObj
	 * @param urlPath
	 * @param parameterName
	 * @param parameterValue
	 * @return Response
	 * @author Swapnil Naidu
	 */
	public Response PUTRequest(JSONObject jsonObj, String urlPath, String parameterName, String parameterValue) {
		return given()
				.pathParam(parameterName, parameterValue)
				.header("Content-Type", "application/json")
				.body(jsonObj.toJSONString())
				.when()
				.put(urlPath+"{"+parameterName+"}")
				.then()
				.extract()
				.response();
	}

	/***
	 * DELETE Request: To delete a particular record based upon path parameter,
	 * parameterName and parameterValue. 
	 * Ex: {@link http://localhost:3030/stores/8928} where 8928 is id {@link http://localhost:3030/stores/{id}}
	 * 
	 * @param urlPath
	 * @param parameterName
	 * @param parameterValue
	 * @return Response
	 * @author Swapnil Naidu
	 */
	public Response DELETERequest(String urlPath, String parameterName, String parameterValue) {
		return given().pathParam(parameterName, parameterValue).when().delete(urlPath + "{" + parameterName + "}")
				.then().extract().response();
	}
	
	/****
	 * PATCH Request: Used when only a few details of a record needs to be updated, using parameterName as
	 * the reference field  and jsonObject as the record data.
	 * @param {@code String } urlPath
	 * @param {@code JSONObject } jsonObj
	 * @param {@code String } parameterName
	 * @param {@code String } parameterValue
	 * @return {@literal Response }
	 * @author Swapnil Naidu
	 */
	public Response PATCHRequest(String urlPath,JSONObject jsonObj ,String parameterName, String parameterValue) {
		return given()
				.pathParam(parameterName, parameterValue)
				.header("Content-Type", "application/json")
				.body(jsonObj.toJSONString())
				.when()
				.patch(urlPath+"{"+parameterName+"}")
				.then()
				.extract()
				.response();
	}
	
}
