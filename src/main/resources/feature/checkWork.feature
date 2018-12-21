//เช็คงานที่ต้องทำ ทั้ง Salon กับ Service

Feature: check to do work
    As a general employee
    I want to check my to do work

Background:

Scenario: There are works to do
    When I click to "To do" button
    Then system show my "To do" item

 Background:

 Scenario: There aren't works to do
     When I click to "To do" button
     Then system show my null item