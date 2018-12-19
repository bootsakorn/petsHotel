// เชคอินให้ลูกค้า

Feature: Check In
    As a Cashier
    I want to check in.

Scenario: choose reserved number and click check in
    Given a customer is Mr.B want to check in with reserved number 3
    When I click check in
    Then system show Mr.B's reserved detail And total price

Scenario: don't have reserved number
    Given a customer is Mr.B want to check in without reserved number
    When I click check in
    Then I can't check in

Scenario: check in after receive money (no change)
    Given total price is 10100 baht
    When I receive 10100 baht from Mr.B
    Then I can check in

Scenario: check in after receive money (have change)
    Given total price is 10100 baht
    When I receive 10200 baht from Mr.B
    Then I can check in And give the change 100 baht to Mr.B






