Feature: Product edit using form

  Background: Go to edit product page
    Given User is on login page
    When User click on menu
    Then Click on filter button
    And click on search textbox
    And click on a approved product


  Scenario: Product edit using form

    And edit the title
    And Sku will be entered
    And Barcode will be entered
    And Submit the changes
    And Go to product list page
    Then Status should be approved
    And logout from seller

  Scenario: Add product with image size more then 10 mb

    And Upload image more then ten mb
    Then File size must be less than ten MB




