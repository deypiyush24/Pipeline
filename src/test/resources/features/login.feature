Feature: OrangeHRM Login

  @smoke
  Scenario: Navigate to OrangeHRM login page
    Given I open the browser
    When I navigate to the OrangeHRM login page
    Then the login page should be displayed

  @smoke
  Scenario: Navigate to OrangeHRM login page
    Given I open the browser
    When I navigate to the OrangeHRM login page
    Then the login page should be displayed
    And  Validate we are on DashBoard Page "Dashboard"

#  @StepTable
#  Scenario: Navigate to OrangeHRM login page
#    Given I open the browser
#    When I navigate to the OrangeHRM login page
#      | UserName | Password     |
#      | Admin    | admin@123    |
#      | Wrong    | password@123 |
#    Then the login page should be displayed
#    And  Validate we are on DashBoard Page