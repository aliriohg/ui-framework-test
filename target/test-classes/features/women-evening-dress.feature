Feature: the user can add blouses to the cart
  the user into evening dress section can add to cart a dress
  the user can select more in the printed dress

  Scenario: user can select a women's blouse to add to cart
    Given the user is on evening dress page
    When the user adds the printed dress to the cart
    Then the page shows "Product successfully added to your shopping cart"

  Scenario: user can select more in blouse
    Given the user is on evening dress page
    When the user click on more in the printed dress
    Then the user is redirected to the printed dress page



