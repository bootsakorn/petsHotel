// อัพเดตห้อง
Feature:
    As  a cashier
    I want to update pet room

Background:
    Given a room type "C"
    And room status "empty"

Scenario:
    When I reserved room type "C"
    Then room status change to "full"
