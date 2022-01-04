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
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
public class stepDefination extends Utils {
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	TestDataBuild td = new TestDataBuild();
	@Given("Add Place payload")
	public void add_place_payload() throws FileNotFoundException {

		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		res=given().spec(requestSpecification())
				.body(td.addPlacePayload());

	}
	@When("user calls {string} with POST http request")
	public void user_calls_with_post_http_request(String string1) {
		response =res.when().post("/maps/api/place/add/json").
				then().spec(resspec).extract().response();
	}
	@Then("the API call is success with status code is {string}")
	public void the_api_call_is_success_with_status_code_is(String string) {
		assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		String resp= response.asString();
		JsonPath jp= new JsonPath(resp);
		assertEquals(jp.get(keyValue).toString(),expectedValue);
	}




}
