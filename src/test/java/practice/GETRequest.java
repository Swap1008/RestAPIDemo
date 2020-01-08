package practice;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GETRequest {
	ExtentHtmlReporter htmlReport= new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\Ex"+System.currentTimeMillis()+".html");
	
	
	ExtentReports reports;
	
	ExtentTest logger;
	
	@BeforeTest
	public void setUp() {
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		htmlReport.config().setReportName("API Test");
		reports.setSystemInfo("Host Name", "Test");
		reports.setSystemInfo("Enviornment", "REST API");
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);
	}

	@Test(priority = 0)
	public void tc001() {
		logger=reports.createTest("passTest");
		RestAssured.baseURI = "http://localhost:3030/products";
		
		Response response=given().when().get().then().extract().response();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.jsonPath().prettify());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 1)
	public void tc002() {
		logger=reports.createTest("failTest");
		
		logger.log(Status.FAIL,MarkupHelper.createLabel("Failed Test Case", ExtentColor.RED));
		Assert.assertTrue(false);
	}
	
	
	@AfterTest
	public void teardown() {
		reports.flush();
	}
}
