Feature: Checks if the current time is represented similar to The Berlin Clock.
  The system will return 0 if no unit in the given block is illuminated
  If some units in a block must be illuminated, it will return the number of blocks that needs to be illuminated.

@wip
Scenario: Current time must be returned to match Berlin clock display
  Given I initialize the current time to be "00:00:01" hrs
  When I make a request to get time display
  Then the returned data must match:
    | Second | 5Hour | 1Hour | 5Minute | 1Minute |
    | 0      | 0     | 0     | 0       | 0       |
