Feature: Test POST Endpoint
  Scenario: Happy Path for POST Employees
    Given I want to add one Employee
    And I setup the new Employee data
    When I send the request
    Then I get response 201
