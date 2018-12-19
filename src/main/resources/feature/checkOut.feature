//เชคเอ้าท์ให้ลูกค้า

Feature: Check out
    As a Cashier
    I want to check out.

Background:

Scenario: choose an appointment number and click check out
    Given a customer "Mr.B" check out with appointment number 3
    When I click appointment number 3
    And I check out
    Then system delete appointment number 3

Background:
Scenario: no have an appointment number and click check out
    Given a customer "Mr.B" check out witout appointment number
    When I click I check out
    Then I can't check out
