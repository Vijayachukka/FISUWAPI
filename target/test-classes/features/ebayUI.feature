@regressionpack
Feature: Test to Navigate to Mottomac Homepage and verify the details
  @smoketest
  Scenario: Test to add product to cart in ebay Home page and verify the details
    Given Launch the ebay website
    And HomePage is displayed
    When search for the "books" in ebay search bar
    And click on the first book in the list
    And click on the "Add to cart" button on product page
    Then cart is updated with product details

