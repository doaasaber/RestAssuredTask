Feature: Retrieve Posts from JSONPlaceholder

  Scenario Outline: Retrieve all posts and verify the response
    Given the base URL is set
    When user send a GET request to : "<EndPoint>"
    Then validate on response status code  : "<StatusCode>"
    And validate on response

    Examples:
      | EndPoint |   | StatusCode |
      | /booking   | | 200        |
