
Feature: check pet name and quantities
    As a salon employee or general employee
    I want to check pet in my reponsibility and quantities of them

Background:

Scenario: get quantities
    When pet name "Alibaba"
    And "Kiki"
    And "Stezi"
    And "Torato"
    Then system show me pet name "Alibaba,Kiki,Stezi,Torato"
    And show quantities 4 pets

Background:
Scenario: don't have pet
    When don't have pet
    Then system show empty list
