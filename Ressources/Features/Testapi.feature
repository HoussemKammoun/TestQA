Feature: Dummy API Test

@smoke
Scenario Outline: Get all the users
	Given The Endpoint of the API Get
	When user send a request to the API
	Then The status code is equal To <code>

Examples:
	|code| |NumberEmplyoees|  
	|200 | |        24     |  
        


