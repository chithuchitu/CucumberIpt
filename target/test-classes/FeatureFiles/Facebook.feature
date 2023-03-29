
Feature: To Test Facebook Functionality
Scenario: To Check the Login Funtionality and Create Account With InValid Functionality
    Given  user give the Invalid Username and Invalid Password
    When user Click The Login Button
    Then user Take Screenshot For Invalid Credential error Message
    Then user Go Back To The Home Page
    Then user Clik The Create New Account Button and Fill The Details
    Then user Take Scrrenshot For The Registeration Page
