// ค้นหาห้องว่างให้ลูกค้า

// ค้นหาห้องและกรงสัตว์เลี้ยง

Feature: search room
    As a cashier
    I want to search the empty room for customer

Scenario: search room for dog
    Given a customer is Mr.B want to find a empty room for dog
    When I choose pet's type dog
    Then system show empty room type A And E

Scenario: search room for cat
     Given a customer is Mr.B want to find a empty room for cat
     When I choose pet's type cat
     Then system show empty room type B And D

Scenario: search room for rabbit
    Given a customer is Mr.B want to find a empty room for rabbit
    When I choose pet's type rabbit
    Then system show empty room type C

Scenario: search room from room type
    Given a customer is Mr.B want to find a single empty room
    When I choose single room
    Then system show empty room type C , D And E

Scenario: search room from room type
    Given a customer is Mr.B want to find a combine empty room
    When I choose combine empty room
    Then system show empty room type A And B

Scenario: search single room for dog
    Given a customer is Mr.B want to find a single room for dog
    When I choose pet's type dog And room type single
    Then system show empty room type  E

Scenario: search combine room for dog
    Given a customer is Mr.B want to find a combine room for dog
    When I choose pet's type dog And room type combine
    Then system show empty room type  A

Scenario: search single room for cat
    Given a customer is Mr.B want to find a single room for cat
    When I choose pet's type cat And room type single
    Then system show empty room type  D

Scenario: search combine room for cat
    Given a customer is Mr.B want to find a combine room for cat
    When I choose pet's type cat And room type combine
    Then system show empty room type  B

Scenario: search single room for rabbit
    Given a customer is Mr.B want to find a single room for rabbit
    When I choose pet's type rabbit And room type single
    Then system show empty room type  C

Scenario: search combine room for rabbit
    Given a customer is Mr.B want to find a combine room for rabbit
    When I choose pet's type rabbit And room type combine
    Then system show empty room type  C

Scenario: search room but rooms are full
    Given a customer is Mr.B want to find a empty room for pet
    When I choose pet's type  And room type
    Then system show rooms are full (room's button is red)




