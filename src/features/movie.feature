Feature: Movie Search

  Background:
    Given I am on the BookMyShow home page
    And I have selected the city "Kolkata"

  Scenario: Search for a currently running movie from and validate results
    When I click on the "<movie>" available in the recommended 
    Then I should see the "<movie>" and booking details
    Examples:
    | movie   |
    | Dhumketu  |
    | War 2 |

  Scenario: Validate key UI elements on Movies screen
    When I am on the BookMyShow home page
    Then all "<elements>" should be visible
    And search bar should be visible
    Examples:
    | elements   |
    | Movies  |
    | Stream |
    | Events  |
    | Plays |
    | Sports  |
    | Activities |
    | ListYourShow |
    | Corporates  |
    | Offers  |
    | Gift Cards |

  Scenario: Explore upcoming movies and validate 'In Cinemas Near You' link
    When I go to the Movies tab
    And I click Explore Upcoming Movies
    Then 'In Cinemas Near You' link should be visible
