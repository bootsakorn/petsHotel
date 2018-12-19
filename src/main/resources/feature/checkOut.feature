//เชคเอ้าท์ให้ลูกค้า

Feature: Check out
    As a Cashier
    I want to check out.

Scenario: choose an appointment number and click check out
    Given a customer is Mr.B want to check out with appointment number 3
    When I click check out
    Then system show alert box "complete" And delete appointment number 3 out from appointment table

Scenario: don't have appointment number
    Given a customer is Mr.B want to check out without appointment number
    When I click check out
    Then I can't check out