Feature: Test the functionality of Cities Endpoint

  This feature checks that Zomato's cities API method
  returns correct data structure of cities information
  based on the query parameters.
  Also, the aim is to validate the API response structure

  Scenario Outline: Check that the API works for valid parameter values
    Given I want to test the details of cities
    And I have set the query parameters <queryParams> with valid data <values>
    And I have set the correct headers for the request
    When I send the request
    Then I should get the response code 200
    And I should get non empty and correct response structure

    Examples:
      | queryParams | values             |
      | q           | Dublin             |
      | q           | LONDON             |
      | lat;lon     | 53.420619;-6.25813 |
      | city_ids    | 91,92              |
      | q; count    | MoNtReAl;3         |



