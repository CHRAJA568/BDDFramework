Feature: Testing the Shopping cart Demo Application

  Background: Open the Shopping cart Application
    Given user opens the Shopping cart

  @SmokeTests @RegressionTests
  Scenario Outline: User successfully opens the shopping cart Application
    When the user is on Homepage
    Then the user is able to see all  the '<Total>' products
     Examples: 
      | Total |
      | 16   |

  @SmokeTests @RegressionTests
  Scenario Outline: User verifies size category filtering has the relevant product listed
    When the user selects the partiular "<SIZE>"
    Then the user sees only the products of relevant size selected and verifies the  '<COUNT>'

    Examples: 
      | SIZE | COUNT |
      | XS   |     1 |

  @SmokeTests @RegressionTests
  Scenario: User verifies all the sort options work correctly
    When the user selects the order by filter lowest to highest
    Then the user verifies the lowest price product is displayed on top

  @SmokeTests @RegressionTests
  Scenario: User is able to add products to cart
    When the user adds one product to cart
    Then the user verifies the count in the cart is displayed as one.

  @SmokeTests @RegressionTests
  Scenario: User verifies the checkout button in cart
    When the user clicks on the cart
    Then the user views the checkout button
