@regressionPack
Feature: Test to Navigate to ebay Homepage and verify the details

  @smokeTest
  Scenario: Test to add product to cart in ebay Home page and verify the details
    Given Launch the ebay website
    And HomePage is displayed
    When search for the "books" in ebay search bar
    And click on the first "1" book in the list
    And switch to the another tab
    And click on the "Add to cart" button on product page
    Then cart is updated with product details

