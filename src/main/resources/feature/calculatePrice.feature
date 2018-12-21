// คิดราคาให้ลูกค้า

Feature: calculate total price
    As a cashier
    I want to calculate total price for customer

Background:
    Given "normal" package price 200 baht
    And "gold II" package price 350 baht
    And food id "3" price 340 baht
    And food id "19" price 240 baht

Scenario: customer has a pet
    When customer choose "normal" package
    And customer choose food id "3"
    Then total price is 540 baht

Background:
Scenario: customer has > 1 pets
     When customer choose "normal" package
     And customer choose "gold II" package
     And customer choose food id "3"
     And customer choose food id "19"
     Then total price is 1030 baht





