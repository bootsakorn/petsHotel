//ใบนัดรับสัตว์เลี้ยง
Feature: make an appointment
    As a cashier
    I want to make an appointmet for customer

Background:

Scenario: insert pet detail
    When I insert pet's detail
    And I click add button
    Then I can make an appointment

Background:

Scenario: click add button without pet detail
    When I don't insert pet's detail
    And I click add button
    Then I can't make an appointment
