Feature: check detail on calendar
    As a cashier
    I want to check detail on calendar

Background:
    Given detial are "Mr.B has to check in"
    And "Miss A has to check out"


Scenario: check 11/12/2561
    When I choose day "11/12/2561"
    And this day has detail
    Then system show "Mr.B has to check in"
    And system show "Miss A has to check out"


Background:
Scenario: check 12/12/2561
    When I choose day "12/12/2561"
    And this day hasn't detail
    Then system show empty
