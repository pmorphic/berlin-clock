Feature: Checks if the current time is represented similar to The Berlin Clock.
  The system will return 0 if no unit in the given block is illuminated
  If some units in a block must be illuminated, it will return the number of blocks that needs to be illuminated.

  Scenario: Current time must be returned to match Berlin clock display
    Given I initialize the current time to be "00:00:01" hrs
    When I make a request to get time display
    Then the system must return "200" status code
    And the returned data must match:
      | secondsDisplayState | 5HourDisplayState | 1HourDisplayState | 5MinuteDisplayState | 1MinuteDisplayState |
      | 0                   | 0                 | 0                 | 0                   | 0                   |

  Scenario: System must return Bad Request status code for invalid time parameter
    Given I initialize the current time to be "xx" hrs
    When I make a request to get time display
    Then the system must return "400" status code

  Scenario: Seconds display state must be correctly set
    Given I initialize the current time to be "00:00:02" hrs
    When I make a request to get time display
    Then the system must return "200" status code
    And the returned data must match:
      | secondsDisplayState | 5HourDisplayState | 1HourDisplayState | 5MinuteDisplayState | 1MinuteDisplayState |
      | 1                   | 0                 | 0                 | 0                   | 0                   |

  Scenario: 5 Hour display state must be correctly set
    Given I initialize the current time to be "10:00:01" hrs
    When I make a request to get time display
    Then the system must return "200" status code
    And the returned data must match:
      | secondsDisplayState | 5HourDisplayState | 1HourDisplayState | 5MinuteDisplayState | 1MinuteDisplayState |
      | 0                   | 2                 | 0                 | 0                   | 0                   |

  Scenario: 1 Hour display state must be correctly set
    Given I initialize the current time to be "02:00:01" hrs
    When I make a request to get time display
    Then the system must return "200" status code
    And the returned data must match:
      | secondsDisplayState | 5HourDisplayState | 1HourDisplayState | 5MinuteDisplayState | 1MinuteDisplayState |
      | 0                   | 0                 | 2                 | 0                   | 0                   |

  Scenario: 5 Minute display state must be correctly set
    Given I initialize the current time to be "00:20:01" hrs
    When I make a request to get time display
    Then the system must return "200" status code
    And the returned data must match:
      | secondsDisplayState | 5HourDisplayState | 1HourDisplayState | 5MinuteDisplayState | 1MinuteDisplayState |
      | 0                   | 0                 | 0                 | 4                   | 0                   |

  Scenario: 1 Minute display state must be correctly set
    Given I initialize the current time to be "00:04:01" hrs
    When I make a request to get time display
    Then the system must return "200" status code
    And the returned data must match:
      | secondsDisplayState | 5HourDisplayState | 1HourDisplayState | 5MinuteDisplayState | 1MinuteDisplayState |
      | 0                   | 0                 | 0                 | 0                   | 4                   |

  Scenario: Current time must be returned to match Berlin clock display
    Given I initialize the current time to be "11:24:06" hrs
    When I make a request to get time display
    Then the system must return "200" status code
    And the returned data must match:
      | secondsDisplayState | 5HourDisplayState | 1HourDisplayState | 5MinuteDisplayState | 1MinuteDisplayState |
      | 1                   | 2                 | 1                 | 4                   | 4                   |
