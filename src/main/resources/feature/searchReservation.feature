Feature: search reservation
    As a Cashier
    I want to search reservation.

Background:
    Given a customer "Mr.B" check in with reserved number 3
    And a customer is "Mr.A" check in without reserved number

Scenario: choose reserved number and click check in
    When I click check in
    Then system show customer's reserved detail
    And system show total price

Background:

Scenario: customers don't have reserved number and I click check in
    When I click check in
    Then I can't check in
