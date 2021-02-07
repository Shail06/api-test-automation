Feature: Test PUT Endpoint
  Scenario: Happy Path for PUT Employees
    Given I want to update one Employee with employee_id 121
    And I setup the new Employee data
    When I send the request
    Then I get response 200
