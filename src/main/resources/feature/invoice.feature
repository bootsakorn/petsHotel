// ออกใบเสร็จให้ลูกค้า

Feature: make invoice
    As a cashier
    I want to make invoice for customer

Background:
    Given total price is 10100 baht

Scenario: no change
    When a customer cash 10100 baht
    Then I give them invoice

Background:

Scenario: has change
    When a customer cash 10200 baht
    Then I give them invoice And change 100 baht

Background:

Scenario: no invoice
    When a customer isn't cash
    Then I can't make invoice