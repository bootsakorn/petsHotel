// เพิ่ม - ลบ พนักงาน

Feature: editEmployee
    As  a owner
    I want to add employee and delete employee

Scenario: add employee
    Given a new employee's name Catherine
    When I hire Catherine
    Then I can add Catherine's detail to system


Scenario: delete employee
    Given an employee's name Catherine
    When I lay off Catherine
    Then I can delete Catherine's detail from system