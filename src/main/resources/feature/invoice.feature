// ออกใบเสร็จให้ลูกค้า

Feather: make invoice
    As a cashier
    I want to make invoice for customer

Scenario: no change
    Given total price is 10100 baht
    When a customer cash 10100 baht
    Then I give them invoice

Scenario: has change
    Given total price is 10100 baht
    When a customer cash 10200 baht
    Then I give them invoice And change 100 baht

Scenario: no invoice
    Given total price is 10100 baht
    When a customer isn't cash
    Then I can't make invoice