// ค้นหาห้องว่างให้ลูกค้า

// ค้นหาห้องและกรงสัตว์เลี้ยง

Feature: search room
    As a cashier
    I want to search the empty room for customer

Background:

Scenario: search room for dog
    Given a customer want to find a empty room for "dog"
    When I choose pet's type "dog"
    Then system show empty room type "A"
    And system show empty room type "E"

Background:

Scenario: search room for cat
     Given a customer want to find a empty room for "cat"
     When I choose pet's type "cat"
     Then system show empty room type "B"
     And system show empty room type "D"

Background:

Scenario: search room for rabbit
    Given a customer  want to find a empty room for "rabbit"
    When I choose pet's type "rabbit"
    Then system show empty room type "C"

Background:

Scenario: search room from room type
    Given a customer want to find a "single" empty room
    When I choose "single" room
    Then system show empty room type "C"
    And system show empty room type "D"
    And system show empty room type "E"

Background:

Scenario: search room from room type
    Given a customer want to find a "combine" empty room
    When I choose "combine" empty room
    Then system show empty room type "A"
    And system show empty room type"B"

Background:

Scenario: search single room for dog
    Given a customer  want to find a "single" room for "dog"
    When I choose pet's type "dog"
    And I choose room type "single"
    Then system show empty room type  "E"

Background:

Scenario: search combine room for dog
    Given a customer want to find a "combine" room for "dog"
    When I choose pet's type "dog"
    And I choose room type "combine"
    Then system show empty room type  "A"

Background:

Scenario: search single room for cat
    Given a customer want to find a "single" room for "cat"
    When I choose pet's type "cat"
    And I choose room type "single"
    Then system show empty room type  "D"

Background:

Scenario: search combine room for cat
    Given a customer want to find a "combine" room for "cat"
    When I choose pet's type "cat"
    And I choose room type "combine"
    Then system show empty room type  "B"

Background:

Scenario: search single room for rabbit
    Given a customer want to find a "single" room for "rabbit"
    When I choose pet's type "rabbit"
    And I choose room type "single"
    Then system show empty room type  "C"

Background:

Scenario: search combine room for rabbit
    Given a customer want to find a "combine" room for "rabbit"
    When I choose pet's type "rabbit"
    And I choose room type "combine"
    Then system show empty room type  "C"

Background:

Scenario: search room but rooms are full
    Given a customer is Mr.B want to find a empty room for pet
    When I choose pet's type  And room type
    Then system show rooms are full (room's button is red)




