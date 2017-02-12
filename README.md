# The Berlin Clock

This project has a REST API endpoint that returns the Berlin Clock display as a Json representation.

The REST endpoint can be accessed using URL **/display-time** and takes a time parameter in HH24:MI:SS format.

### Sample request
curl http://localhost:8080/display-time?time='20:10:05'

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
The properties in the Json object represent rows in the Berlin Clock and the values represent the number of lights to be illuminated for the specific row.

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
