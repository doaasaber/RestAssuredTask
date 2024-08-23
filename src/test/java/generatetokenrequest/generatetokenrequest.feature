Feature: Verify that response not empty and response generate token

  Scenario Outline: Verify that response not empty and response generate token
    Given the base URL is set
    When user put valid data based on sentence from row: "<rowNumber>"
    And user send to post endpoint : "<endPoint>"
    Then validate on response status code  : "<statusCode>"
    And validate on response:"<response>"

    Examples:
     |rowNumber| | endPoint | | statusCode | |response|
     | 1        ||/auth/    | | 200        | | token |