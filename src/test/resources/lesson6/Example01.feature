@run
Feature: Example01

  Scenario: Login test
    Given I am on the JDI Index Page
    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'

#    Scenario: Some sc
#      Given I login as 'epam'/'1234'
#      When I get some data from web page
#      Then Some data from the we page should be equal to 'My name'


  @skip
  Scenario: Login test fail
    * I am on the JDI Index Page
    * I login as 'epam'/'1234'
    * User name should be 'PITER CHAILOVSKII1'


#  Scenario: Login test with user entity
#    Given I am on the JDI Index Page
#    When I login as
#      | userName | password  |
#      | epam     | 1234      |
#      | uuuu     | uuuu      |
#      | dsdjkhk  | hdjhsdjks |
#      | djsdksdj | sdjhds    |
#    Then User name should be 'PITER CHAILOVSKII'

  Scenario: Test check header
    Given I am on the JDI Index Page
    And I login as
      | userName | password |
      | epam     | 1234     |
    When I click 'Service' header menu button
    Then Dropdown list should be displayed
    And Dropdown list should have 'Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements' items


    And Left side menu should have
      | Support | Dates | Complex Table | Simple Table | Tables With Pages | Different Elements |