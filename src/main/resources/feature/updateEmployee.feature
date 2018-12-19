// อัพเดต ข้อมูลมพนักาน
Feature: editEmployee
    As  a owner
    I want to  update employee

Background:

Scenario:
    Given an employee "Mrs.C" change her "name"
    When employee had changed details
    Then I can change "Mrs.C" "name"

Background:

Scenario: Don't have employee detail
    Given an employee "Mrs.C" no have detail on system
    When employee had changed details
    Then I can add employee's detail
