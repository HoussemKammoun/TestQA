@API
Feature: API Dummy Tests

@userData
Scenario Outline: As a user I want to check that users data has the right format
	Given The Endpoint of the API Dummy
	When I send a request to the get users
	Then The status code is equal To <code>
	And the number of employees in the response is <NumberEmplyoees>
	And the employeeName and the employeeSalary have the good format

Examples:
	|code| |NumberEmplyoees|  
	|200 | |        24     |  
        


