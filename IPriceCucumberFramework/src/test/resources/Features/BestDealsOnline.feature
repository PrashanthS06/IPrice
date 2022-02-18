## a. Grab the list of stores in the “Find the Best Deals Online”
## b. Count the list of the stores in the “Find the Best Deals Online”
Feature: feature to test Count and list of the stores in Best Deals Online

  Scenario: Verify the Count and list of the stores in the Find the Best Deals Online
    Given user navigates to the URL
    When tries to find the Best Deals Online
    Then display the list of the stores
    And count of the stores
