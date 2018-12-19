// อัพเดต ข้อมูลมพนักาน
Feature: editEmployee
    As  a owner
    I want to  update employee


Scenerio:
    Give a owner
    When emmployee had changed details
    Then I can edit  employee's detail to system


Scenerio: Don't have employee detail
    When emmployee had changed details
    Then I can add employee's detail to system
