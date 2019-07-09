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
#    Then I navigate to the 'Different Elements' page
    Then 'Different Elements' page contains 4 checkboxes, 4 radios, 1 dropdown and 2 buttons
    And There is the Right Section
    And There is the Left Section
    When I select 'Water' and 'Wind' checkboxes
    Then 'Water' and 'Wind' checkboxes are selected
    # TODO Step a bit not clear => fixed || resolved
    And 'Water' and 'Wind' are present in the log as 'true'
    When I select the 'Selen' radio button
    Then 'Selen' radio button is selected
    # TODO Step a bit not clear => fixed || resolved
    And 'Selen' is present in the 'Metals: ' log row
    When I select 'Yellow' in the dropdown
    Then 'Yellow' is selected in the dropdown
    # TODO Step a bit not clear => fixed || resolved
    And 'Yellow' is present in the 'Colors: ' log row
    When I deselect 'Water' and 'Wind' checkboxes
    Then 'Water' and 'Wind' checkboxes are deselected
    # TODO Step a bit not clear => fixed || resolved
    And 'Water' and 'Wind' are present in the log as 'false'