// คิดราคาให้ลูกค้า

Feature: calculate total price
    As a cashier
    I want to calculate total price for customer

Background:
    Given "normal" package price 200 baht
    And "silver" package price 250 baht
    And "gold I" package price 300 baht
    And "gold II" package price 350 baht
    And "super gold" package price 400 baht
    And "dimond" package price 500 baht

Scenario: customer has a pet
    When customer choose "normal" package
    Then total price is 200 baht

Background:
Scenario: customer has > 1 pets
     When customer choose "normal" package
     And customer choose "gold II" package
     Then total price is 550 baht

