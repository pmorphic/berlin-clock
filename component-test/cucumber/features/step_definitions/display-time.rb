require 'rest-client'
require 'rspec'
require 'json'

Given /^I initialize the current time to be "([^"]*)" hrs$/ do |time|
  @current_time = time
end

When /^I make a request to get time display$/ do
  url = "#{BASE_URL}/display-time"
  response = RestClient.get url, {params: {time: @current_time}}
  @response_body = JSON.parse(response.body)
end

Then /^the returned data must match:$/ do |table|
  table.hashes.each do |row|
    expect(@response_body["seconds"]).to eq(row["seconds"].to_i)
    expect(@response_body["5Hour"]).to eq(row["5Hour"].to_i)
    expect(@response_body["1Hour"]).to eq(row["1Hour"].to_i)
    expect(@response_body["5Minute"]).to eq(row["5Minute"].to_i)
    expect(@response_body["1Minute"]).to eq(row["1Minute"].to_i)
  end

end
