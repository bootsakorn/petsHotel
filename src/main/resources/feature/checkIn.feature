// เชคอินให้ลูกค้า

Feature: Check In
    As a Cashier
    I want to check in.

Background:

Scenario: check in after receive money (no change)
    Given a customer Mr.B check in with reserved number 3
    When I receive 10100 baht from Mr.B
    Then I can check in

Background:

Scenario: check in after receive money (have change)
    Given a customer Mr.B check in without reserved number
    When I receive 10200 baht from Mr.B
    Then I can check in
    And I give the change 100 baht to Mr.B






