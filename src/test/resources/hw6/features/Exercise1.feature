@exercise
Feature: Different Elements Page Functionality

  Scenario: Different Elements Page Test
    Given I am on the JDI Index Page
    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'
    And There are 4 pictures, 4 texts under them, a headline and a description
    When I click 'SERVICE' header menu button
    Then Dropdown should contain the following items: 'Support, Dates, Complex Table, Simple Table, User Table, Table with pages, Different elements, Performance'
    When I click 'DIFFERENT_ELEMENTS' in the 'Service' dropdown
    Then 'Different Elements' page contains 4 checkboxes, 4 radios, 1 dropdown and 2 buttons
    # TODO There is - where is it?
    And There is the Right Section
    # TODO There is - where is it?
    And There is the Left Section
    # TODO I recommend add some location where these elements exist
    When I select 'Water' and 'Wind' checkboxes
    Then 'Water' and 'Wind' checkboxes are selected
    And 'Water' and 'Wind' are present in the log as 'true'
    When I select the 'Selen' radio button
    Then 'Selen' radio button is selected
    And 'Selen' is present in the 'Metals: ' log row
    When I select 'Yellow' in the dropdown
    Then 'Yellow' is selected in the dropdown
    And 'Yellow' is present in the 'Colors: ' log row
    When I deselect 'Water' and 'Wind' checkboxes
    Then 'Water' and 'Wind' checkboxes are deselected
    And 'Water' and 'Wind' are present in the log as 'false'