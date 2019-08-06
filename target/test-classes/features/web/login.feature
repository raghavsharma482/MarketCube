Feature: Product edit using form

  Background: I login as seller
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
    And Assert the approved status
    And logout from seller

  Scenario: Add product with image size more then 10 mb

    And Upload image more then ten mb
    And File size must be less than ten MB




