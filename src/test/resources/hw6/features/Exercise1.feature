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
    # TODO There is - where is it? => That's what the spec says: "Assert that there is Right Section"
    # TODO Not resolved => fixed || resolved
    And There is the Right Section in the right part of the page
    # TODO There is - where is it? => That's what the spec says: "Assert that there is Left Section"
    # TODO Not resolved => fixed || resolved
    And There is the Left Section in the left part of the page
    # TODO I recommend add some location where these elements exist => fixed || resolved
    # TODO at the top? It is where? => fixed || resolved
    When I select checkboxes: 'Water, Wind' at the top of the main content section
    Then Checkboxes are selected: 'Water, Wind'
    And 'Water' and 'Wind' are present in the log as 'true'
    When I select the 'Selen' radio button
    Then 'Selen' radio button is selected
    And 'Selen' is present in the 'Metals: ' log row
    When I select 'Yellow' in the dropdown
    Then 'Yellow' is selected in the dropdown
    And 'Yellow' is present in the 'Colors: ' log row
    When I deselect 'Water' and 'Wind' checkboxes
    Then Checkboxes are deselected: 'Water, Wind'
    And 'Water' and 'Wind' are present in the log as 'false'