require 'rest-client'
require 'rspec'
require 'json'

When(/^I make a request to get display state for "([^"]*)"$/) do |time|
  @start_time = Time.now
  param = {}
  param = {params: {time: time}} unless time.eql?('<blank>')
  url = "#{BASE_URL}/display-time"

  begin
    @response = RestClient.get url, param
  rescue RestClient::ExceptionWithResponse => e
    @response = e.response
  end
end

Then(/^the system must return "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)"$/) do |sec, five_hour, one_hour, five_min, one_min|
  response_body = JSON.parse(@response.body)

  expect(response_body["secondsDisplayState"]).to eq(sec.to_i)
  expect(response_body["5HourDisplayState"]).to eq(five_hour.to_i)
  expect(response_body["1HourDisplayState"]).to eq(one_hour.to_i)
  expect(response_body["5MinuteDisplayState"]).to eq(five_min.to_i)
  expect(response_body["1MinuteDisplayState"]).to eq(one_min.to_i)
end

Then /^the system must return "([^"]*)" status code$/ do |status_code|
  expect(@response.code).to eq(status_code.to_i)
end

Then /^the returned data must be for the current system time$/ do
    end_time = Time.now
    response_body = JSON.parse(@response.body)
    rtrn_hour = response_body["5HourDisplayState"] * 5 + response_body["1HourDisplayState"]
    rtrn_min = response_body["5MinuteDisplayState"] * 5 + response_body["1MinuteDisplayState"]

# Check if the returned hour and minutes match either the start or end time of test
# This is to allow for boundary cases where the hour/min might transition during the test.
    expect(rtrn_hour == @start_time.hour || rtrn_hour == end_time.hour).to be true
    expect(rtrn_min == @start_time.min || rtrn_min == end_time.min).to be true
end
