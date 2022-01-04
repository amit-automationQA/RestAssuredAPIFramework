package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;



public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		stepDefination step = new stepDefination();
		if(stepDefination.place_id==null)
		{
		step.add_place_payload_with("Shetty", "French", "Asia");
		step.user_calls_with_post_http_request("AddPlaceAPI", "POST");
		step.verify_place_id_created_maps_to_using("Shetty", "getPlaceAPI");
		}
		
	}

}
