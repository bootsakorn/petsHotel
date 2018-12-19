//  จองห้องและแพคเกจให้ลูกค้า

Feature: reserve the room
    As a cashier
    I want to reserve room

Scenario: can reserve the room
    Given a customer is Mr.B want to reserved a combine room for dog
    When I choose pet's type dog , room type combine And room's status is empty
    Then I can reserve this room

Scenario: can't reserve the room
    Given a customer is Mr.B want to reserved a combine room for dog
    When I choose pet's type dog , room type combine And room's status is full
    Then I can't reserve this room