## c. Count the list of items in “Top Trending Products”
## d. Validate that each item in “Top Trending Products” contains “data-vars-cgt”
Feature: feature to test the Count and validate the each items in Top Trending Products
  			that contains data-vars-cgt

  Scenario: Verify the Count of list of items in Top Trending Products
    Given user navigates to the Trending Products URL
    When tries to find the Top Trending Products
    Then display the count of the Top Trending Products
    And Validate the Top Trending Products
