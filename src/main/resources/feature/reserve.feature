//  จองห้องและแพคเกจให้ลูกค้า

Feature: reserve the room
    As a cashier
    I want to reserve room

Background:
    Given a customer is "Mr.B" want to reserved a "combine" room for "dog"
    And status room "active"

Scenario: can reserve the room
    When I choose pet type "dog"
    And I choose "combine" room
    And  status room "active"
    Then I can reserve this room

Background:

Scenario: can't reserve the room

     When I choose pet type "dog"
     And I choose "combine" room
     And  status room "unactive"
     Then I can't reserve this room