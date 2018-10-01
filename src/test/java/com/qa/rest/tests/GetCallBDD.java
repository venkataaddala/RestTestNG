package com.qa.rest.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCallBDD {
	
	@Test
	public void test_numberofCircuitsfor2017()
	{
		given().
		when().
			get("http://ergast.com/api/f1/2017/Circuits.json").
		then().
			assertThat().
			statusCode(200).
			and().
			body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
			and().
			header("Proxy-Connection",equalTo("Keep-Alive"));
	}
	
	@Test
	public void PostRequestRest()
	{
		
		String EndPoint="https://reqres.in";
		
	    RequestSpecification requestspec=RestAssured.given().baseUri(EndPoint);
	    JsonObject requestparams=new JsonObject();
	    requestparams.addProperty("name", "morpheus");
	    requestparams.addProperty("job", "leader");
	    
	    requestspec.header("Content-Type", "application/json");
	    requestspec.body(requestparams.toString());
	    Response response=requestspec.post("/api/users");
	    
	    int statuscode=response.getStatusCode();
	    Assert.assertEquals(Integer.toString(statuscode), "201");
	    
	}
	

}
