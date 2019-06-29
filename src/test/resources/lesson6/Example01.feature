@run
Feature: Example01

  @do
  Scenario: Login test 1
    Given I am on the JDI Index page
    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'

#  Scenario: Some sc
#    Given I login as 'epam'/'1234'
#    When I get some data from web page
#    Then Some data from the web page should be equal to 'My name'

  @do
  Scenario: Login test failed 1
    Given I am on the JDI Index page
    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII1'