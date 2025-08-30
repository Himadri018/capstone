Feature: Gift Card
  Background:
    Given I am on the BookMyShow home page
    And I have selected the city "Kolkata"

  Scenario: Validate Check Gift Card Balance icon is visible
    When I go to the Gift Cards tab
    Then the Check Gift Card Balance icon should be visible

  Scenario: Check gift card balance with invalid voucher
    When I go to the Gift Cards tab
    And I click on Check Gift Card Balance
    And I enter invalid voucher number "12345678900"
    And I submit gift card balance check
    Then an error message should be shown for invalid voucher
