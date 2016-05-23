Feature: List available books

  Scenario: Listing available books
    Given the user is on the site's home page
    When the user clicks on the 'Books' tab
    Then they should see the list of available books