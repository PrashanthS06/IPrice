## b. Make sure that list of stores in "Top Stores” is redirected to their proper store url
Feature: feature to test the url of stores in Top Stores are all active and redirected to their proper store url

  Scenario: Verify the url of stores in Top Stores are redirected to their proper store url
    Given user navigates to the Top Stores URL
    When tries to find the Top Stores
    Then Validate url of stores in Top Stores redirected to their proper store url
