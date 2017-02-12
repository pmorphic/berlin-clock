# The Berlin Clock

This project has a REST API endpoint that returns the Berlin Clock display as a Json representation.

The REST endpoint can be accessed using URL /display-time and takes a time parameter in HH24:MI:SS format.

It returns a JSON output in the following format:
```json
{
    "secondsDisplayState":1,
    "5HourDisplayState":2,
    "1HourDisplayState":1,
    "5MinuteDisplayState":4,
    "1MinuteDisplayState":4
}
```
Each property in the Json object represents a row in the Berlin Clock.
Value 0 for a property signifies no lights are illuminated for the specified row in the clock..
Value 1 or more for a property signifies the number of lights to be illuminated for the specified row in the clock.

## Getting Started

### Prerequisities

You'll need to install:

 * Java8
 * Ruby
 * Bundler
 * Cucumber
 * Maven

### Installing

First clone the project, then run
```bash
cd <project-home-dir>
mvn clean install
```

## Starting the app server

```bash
cd <project-home-dir>
./run
```

the server will be running at port 8080

## Running the component tests

First start the app server, then run

```bash
cd <project-home-dir>/component-test/cucumber
bundle install
./test
```

## License

This project is licensed under the MIT License.
