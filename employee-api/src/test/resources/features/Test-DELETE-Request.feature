Feature: Test DELETE Endpoint
  Scenario: Happy Path for DELETE Employee
    Given I want to delete one Employee with employee_id 130
    When I send the request
    Then I get response 204
