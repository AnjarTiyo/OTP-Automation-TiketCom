Feature: Login with OTP

  As an Registered User,
  I want to __login with my credentials__
  In order to **access logged in user feature**

  Scenario: Verify OTP Login functionality
    Given User already on Login Page
    When User enter registered phone number
    And User input OTP
    Then User logged in
