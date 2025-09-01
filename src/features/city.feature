Feature: City Search

  Scenario: Search with a valid city name
  	Given I am on the BookMyShow home page
    When I open the city selector
    And I search city "<city>"
    Then I should see "<city>" in the city results
    Examples:
    | city   |
    | Kolkata  |
    
  Scenario: Search with an invalid/non-existing city
    When I give invalid city name
    And I search city "<city>"
    Then I should see a no-results message
    Examples:
    | city   |
    | canada  |

  Scenario: Select city using popular city icons
    When I open the city selector
    And I click the popular city "<city>" with icon
    Then the site context should change to "<city>"
    Examples:
    | city   |
    | Kolkata  |

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
