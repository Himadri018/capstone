Feature: City Search

  Scenario: Search with a valid city name
  	Given I am on the BookMyShow home page
    When I open the city selector
    And I search city "Kolkata"
    Then I should see "Kolkata" in the city results

  Scenario: Search with an invalid/non-existing city
    When I give invalid city name
    And I search city "canada"
    Then I should see a no-results message

  Scenario: Select city using popular city icons
    When I open the city selector
    And I click the popular city "kolkata" with icon
    Then the site context should change to "kolkata"

  Scenario: View all cities and validate a few non-popular names
    When I open the city selector
    And I click View All Cities
    Then I should see the cities "<city>" in All Cities
    Examples:
    | city   |
    | Patna  |
    | Kanpur |
    | Agra   |
    | Maheshtala   |
