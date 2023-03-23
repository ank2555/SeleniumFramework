Feature: Login on Application site




  Scenario: Account Creation on Merchant Site
    Given User is on Merchant Page
    When User Click on Account to Login
    And User provide all Account Detail to create Account on Login Page
    And User click on Register
    Then Account Page is Displayed


#  Scenario: Home Page Default Login
#    Given User is on Merchant Page
#    When User Click on Account to Login
#    And User Login into Using username and password
#    Then Homepage is populated


