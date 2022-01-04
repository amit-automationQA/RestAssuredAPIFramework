package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
public class stepDefination extends Utils {
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	TestDataBuild td = new TestDataBuild();
	String place_id;
	JsonPath jp;
	@Given("Add Place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		
		res=given().spec(requestSpecification())
				.body(td.addPlacePayload(name,language,address));

	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource ,String methodtype) {
		
		//constructor will be passed with the value which you have passed
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(methodtype.equalsIgnoreCase("POST"))
		response =res.when().post(resourceAPI.getResource());
		else if (methodtype.equalsIgnoreCase("GET"))
			response =res.when().get(resourceAPI.getResource());
	}
	
	@Then("the API call is success with status code is {string}")
	public void the_api_call_is_success_with_status_code_is(String string) {
		assertEquals(response.getStatusCode(),200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		assertEquals(getJsonPath(response, keyValue).toString(),expectedValue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		String place_id=getJsonPath(response, "place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_post_http_request(resource, "GET");
		String actualName= getJsonPath(response, "name");
		assertEquals(actualName,expectedName);
	}




}
