Feature: Validating Place API's
Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
	Given Add Place payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" http request
	Then the API call is success with status code is "200"
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
Examples:
|name    |language|address           |
|AAAhouse|English |World trade center|
|BBhouse |Spanish |Cross center      |


Scenario: To verify if Delete place functionality is working

Given DeletePlace Payload
When user calls "deletePlaceAPI" with "POST" http request
Then the API call is success with status code is "200"
And "status" in response body is "OK"