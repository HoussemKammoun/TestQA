Feature: Dummy API Test

@smoke
Scenario Outline: Get all the users
	Given The Endpoint of the API Dummy
	When I send a request to the get users
	Then The status code is equal To <code>
	And I verify the number of employees in the response is <NumberEmplyoees>

Examples:
	|code| |NumberEmplyoees|  
	|200 | |        24     |  
        


