// อัพเดต ข้อมูลมพนักาน
Feature: editEmployee
    As  a owner
    I want to  update employee


Scenario:
    Given a owner
    When emmployee had changed details
    Then I can edit  employee's detail to system


Scenario: Don't have employee detail
    When emmploye had changed details
    Then I can add employee's detail to system
