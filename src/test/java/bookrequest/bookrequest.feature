Feature:Verify that book is added successfully

  Scenario Outline:Verify that book is added successfully
    Given the base URL is set
    When user put valid data based on sentence from row: "<rowNumber>"
    And user send a POST request to : "<endPoint>"
    Then validate on response status code  : "<statusCode>"
    And validate on response

    Examples:
    |rowNumber|  | endPoint |   | statusCode |
    |1        |  |/booking  |   | 200        |