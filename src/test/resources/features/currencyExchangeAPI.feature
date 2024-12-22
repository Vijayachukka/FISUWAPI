Feature: Verify the currency details in API and  verify the response

  @apitest1
  Scenario: Retrieve the currency details by using GET request and verify the details
#    Given request is prepared for the request
    When request is triggered with GET method
#    Then "200" status code should be returned
#    And verify the "GBP" description in response