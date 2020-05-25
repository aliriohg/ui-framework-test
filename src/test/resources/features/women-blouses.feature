Feature: the user can add blouses to the cart
  the user into blouses section can add to cart a blouse
  the user can select more in the blouse

  Scenario: user can select a women's blouse to add to cart
    Given the user is on blouses page
    When the user adds the blouse to the cart
    Then the page shows "Product successfully added to your shopping cart"

  Scenario: user can select more in blouse
    Given the user is on blouses page
    When the user click on more in the blouse
    Then the user is redirected to the blouse page



