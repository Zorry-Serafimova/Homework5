Feature: Test for editing user for the https://seleniumclass.000webhostapp.com/web/index.php?r=users%2Findex

  Scenario: Add User via API, edit user with Selenium
    Given User is created via api
    When User goes to page
    And User clicks on update button
    And User puts new values in all Fields and clicks Update
    Then User information is updated

