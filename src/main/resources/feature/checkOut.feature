Feature: Check out
    As a Cashier
    I want to check out.

Scenario: choose an appointment number and click check out
    Given a customer "Mr.B" check out with appointment number 26
    When I click appointment number 26
    And I check out
    Then system edit status in checkout number 10 to true

#Background:
#Scenario: no have an appointment number and click check out
#    Given a customer "Mr.B" check out witout appointment number
#    When I click I check out
#    Then I can't check out
