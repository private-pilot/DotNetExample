Feature: Create a new book

  Scenario Outline: Jane Austin releases Pride and Prejudice sequel
    Given the user is on the site's home page
    When the user clicks on the 'Books' tab
    And the user clicks on the Create New Book link
    And the user creates a new book with '<genre>', '<price>', '<title>', '<authorFirstName>', '<authorLastName>', and '<year>'
    And the user clicks the Create book button
    Then the book with title '<title>' should be visible on the Books Listing page

    Examples:
      | genre | price | title | authorFirstName | authorLastName | year |
      | Comedy of manners | 20 | Pride and Prejudice | Jane | Austen | 1900 |