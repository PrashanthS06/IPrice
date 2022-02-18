## a. Make sure that url of stores in Top Stores are all active
Feature: feature to test the url of stores in Top Stores are all active and redirected to their proper store url

  Scenario: Verify the url of stores in Top Stores are all active
    Given user navigates to the Top Stores
    When tries to find the Active Top Stores
    Then Validate url of stores in Top Stores are all active
    