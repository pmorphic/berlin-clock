require 'rest-client'
require 'rspec'
require 'json'

Given /^I initialize the current time to be "([^"]*)" hrs$/ do |time|
  @current_time = time
end

When /^I make a request to get time display$/ do
  url = "#{BASE_URL}/display-time"
  begin
    @response = RestClient.get url, {params: {time: @current_time}}
  rescue RestClient::ExceptionWithResponse => e
    puts e.response
    @response = e.response
  end
end

Then /^the returned data must match:$/ do |table|
  response_body = JSON.parse(@response.body)

  table.hashes.each do |row|
    expect(response_body["secondsDisplayState"]).to eq(row["secondsDisplayState"].to_i)
    expect(response_body["5HourDisplayState"]).to eq(row["5HourDisplayState"].to_i)
    expect(response_body["1HourDisplayState"]).to eq(row["1HourDisplayState"].to_i)
    expect(response_body["5MinuteDisplayState"]).to eq(row["5MinuteDisplayState"].to_i)
    expect(response_body["1MinuteDisplayState"]).to eq(row["1MinuteDisplayState"].to_i)
  end
end

Then /^the system must return "([^"]*)" status code$/ do |status_code|
  expect(@response.code).to eq(status_code.to_i)
end
