@run
Feature: Example03

  Scenario: Login test 2
    Given I am on the JDI Index Page
    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'

#    Scenario: Some sc
#      Given I login as 'epam'/'1234'
#      When I get some data from web page
#      Then Some data from the we page should be equal to 'My name'


  @skip
  Scenario: Login test fail 2
    * I am on the JDI Index Page
    * I login as 'epam'/'1234'
    * User name should be 'PITER CHAILOVSKII1'