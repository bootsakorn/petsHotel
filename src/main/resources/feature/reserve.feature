//  จองห้องและแพคเกจให้ลูกค้า

Feature: reserve the room
    As a cashier
    I want to reserve room

Background:
    Given a customer is choose "normal" package
    And status room "active"


Scenario: can reserve the room
    When I choose "normal" package
    And  status room "active"
    Then I can reserve this room

Background:

Scenario: can't reserve the room
     When I choose "normal" package
     And  status room "unactive"
     Then I can't reserve this room