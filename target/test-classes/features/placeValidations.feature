Feature: Validating Place API's
Scenario: Verify if Place is being successfully added using AddPlaceAPI
	Given Add Place payload
	When user calls "AddPlaceAPI" with POST http request
	Then the API call is success with status code is "200"
	And "status" in response body is "OK"
	And "scope" in response body is "APP"