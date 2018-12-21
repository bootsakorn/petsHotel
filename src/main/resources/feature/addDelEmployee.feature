// เพิ่ม - ลบ พนักงาน
Feature: add or delete employee's detail
    As a Owner
    I want to add employee or delete employee

Background:

Scenario: hire new employee
    Given an employee name "Mr.A"
    When I hire "Mr.A"
    Then I can add "Mr.A" detail

Background:

Scenario: lay-off employee
     Given an employee name "Mr.A"
     When I lay-off "Mr.A"
     Then I can delete "Mr.A" detail