Feature: add new customer detail
    As a cashier
    I want to add new customer detail

Background:
    Given a customer name "Mr.A"
    And system doesn't have detail

Scenario: has new customer
    When I add "Mr.A" detail
    And I confirmed
    Then system has "Mr.A" detail

Background:
Scenario: has new customer
    When I add "Mr.A" detail
    And I cancled
    Then system hasn't "Mr.A" detail