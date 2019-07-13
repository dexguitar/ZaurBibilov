@exercise
Feature: User Table Page Functionality

  Scenario: User Table Page test
    Given I am on the JDI Index Page
    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'
    When I click 'SERVICE' header menu button
    And I click 'USER_TABLE' in the 'Service' dropdown
    Then I am on the 'User Table' page
    And There are 6 dropdowns, usernames, images, texts and checkboxes displayed
    And User Table contains following values:
      | userNumber | userName         | userDescription |
      | 1          | Roman            | Wolverine       |
      | 2          | Sergey Ivan      | Spider Man      |
      | 3          | Vladzimir        | Punisher        |
      | 4          | Helen Bennett    | Captain America |
      | 5          | Yoshi Tannamuri  | Cyclope         |
      | 6          | Giovanni Rovelli | Hulk            |
    When I select vip checkbox for 'Sergey Ivan'
    Then Log row has 'Vip: condition changed to true' text in log section
    When I click on dropdown in column Type for user 'Roman'
    Then Droplist for user 'Roman' contains values: 'Admin, User, Manager'
#    Then Droplist for user 'Roman' contains values:
#    | value   |
#    | User    |
#    | Admin   |
#    | Manager |