package restUsingtestNG;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestRunner {

	@Test
	public void getRequest()
	{
		RestAssured.baseURI="http://ergast.com";
		given().
		when().
			get("/api/f1/2017/Circuits.json").
		then().
			assertThat().
			statusCode(200).
			and().
			body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
			and().
			header("Proxy-Connection",equalTo("Keep-Alive"));
	}
	
	@Test
	public void postRequest()
	{
		File file=new File("C:\\Users\\venkata.addala\\workspace\\RestAssuredTestNG\\Payload\\postRequestJson");
		
		RestAssured.baseURI="https://reqres.in";
		given().
			body(file).
			header("Content-Type", "application/json").
			log().all().
		when().
			post("/api/users").
		then().
			assertThat().
			statusCode(201).
			and().
			body("name", equalTo("morpheus")).
			and().
			body("job", equalTo("leader")).
			and().log().all();
	}
}
