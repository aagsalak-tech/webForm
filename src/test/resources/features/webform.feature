Feature: Selenium Web Form Launch

  Scenario: Open the Selenium Web Form and Validate Fields
    Given I open the Selenium web form page
    And Page title is Valid
    And Disabled input is disabled
    And Check radio is selected
    When I submit form
    And Form is submitted
    And I navigate back
    Then Page title is Valid

    Scenario: Enter Text Details and Submit Form
      Given I open the Selenium web form page
      When  I enter Text input text
      And I enter Password text
      And I enter Text Area text
      And I submit form
      Then Form is submitted

      Scenario Outline: Select drop down, upload File and Submit Form
        Given I open the Selenium web form page
        And  I enter Text input text
        And I select drop down
        And I select option from datalist
        And I select "<form_date>"
        When I upload a file
        And I submit form
        Then Form is submitted

        Examples:
          |form_date|
          |2025-04-15|
          |2025-05-15|