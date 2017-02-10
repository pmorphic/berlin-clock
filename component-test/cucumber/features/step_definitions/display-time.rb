require 'rest-client'
require 'rspec'

Given /^I initialize the current time to be "([^"]*)" hrs$/ do |time|
  @current_time = time
end

When /^I make a request to get time display$/ do
  url = "#{BASE_URL}/display-time"
  @response = RestClient.get url, {params: {time: @current_time}}
  puts @response
end

Then /^the returned data must match:$/ do |table|
  # table is a Cucumber::Ast::Table
  pending # express the regexp above with the code you wish you had
end
