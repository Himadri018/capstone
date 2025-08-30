Feature: Login Module

Scenario: Valid login with valid credentials
	Given I go to BMS Page
	When I select my city
	And I Login with valid mobile and got to otp page
	Then otp page must be shown
Scenario: Invalid login with invalid credentials
	When  I Login with invalid mobile number
	Then Error should appear
Scenario: Elements should be visible
	Then login button should be visible
    And mobile input field should be visible

