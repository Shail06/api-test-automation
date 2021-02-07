Feature: Test Get All Employee Data
  Scenario: Happy Path for GET Employees
    Given I want to get all Employees
    When I send the request
    Then I get response 200
