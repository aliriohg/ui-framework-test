Feature: User can add multiple items to cart

  #The scenario failed becouse when the user click in continue shopping
  #the user doesn't return to homepage
  Scenario: User can add women blouse
    Given the user is on Homepage
    And the user clicks Women
    And user clicks Tops
    And User Clicks blouses
    And user clicks on add to cart
    When the user clicks on continue shopping
    Then the user is returned to the homepage

  Scenario: user can add women evening dress
    Given the user is on Homepage
    And the user clicks Women
    And user clicks Dresses
    And User Clicks evening dresses
    And user clicks on (Quick View) printed dress
    And user clicks on add to cart from Pop up
    When the user clicks on continue shopping
    Then the user is returned to the homepage

##the state between scenario is not shared
  Scenario: user verifies shopping cart has 2 items in cart
    Given the user is on Homepage
    And the user clicks Cart
    And the cart has 2 products
    When User Clicks checkout
    Then user is taken to the Authentication screen
