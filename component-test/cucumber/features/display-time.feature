Feature: Checks if the current time is represented similar to The Berlin Clock.
  The system will return 0 if no unit in the given block is illuminated
  If some units in a block must be illuminated, it will return the number of blocks that needs to be illuminated.

  Scenario Outline: System must return data to match Berlin clock display for input time
    When I make a request to get display state for "<time>"
    Then the system must return "200" status code
    And  the system must return "<secondsDisplayState>", "<5HourDisplayState>", "<1HourDisplayState>", "<5MinuteDisplayState>", "<1MinuteDisplayState>"
    Examples:
      | time     | secondsDisplayState | 5HourDisplayState | 1HourDisplayState | 5MinuteDisplayState | 1MinuteDisplayState |
      | 00:00:01 | 0                   | 0                 | 0                 | 0                   | 0                   |
      | 00:00:02 | 1                   | 0                 | 0                 | 0                   | 0                   |
      | 15:00:01 | 0                   | 3                 | 0                 | 0                   | 0                   |
      | 02:00:01 | 0                   | 0                 | 2                 | 0                   | 0                   |
      | 00:20:01 | 0                   | 0                 | 0                 | 4                   | 0                   |
      | 00:04:01 | 0                   | 0                 | 0                 | 0                   | 4                   |
      | 11:24:06 | 1                   | 2                 | 1                 | 4                   | 4                   |
      | 10:31:04 | 1                   | 2                 | 0                 | 6                   | 1                   |

  Scenario: System must return Bad Request status code for invalid time parameter
    When I make a request to get display state for "xx"
    Then the system must return "400" status code

  Scenario: System must return data for current time when no input time present
    When I make a request to get display state for "<blank>"
    Then the system must return "200" status code
    And the returned data must be for the current system time
