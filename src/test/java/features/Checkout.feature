Feature: Search and Place the order for products
  Background:
    #When Launch the browser from config variables
    #And Hit the home page url of banking site
    #//Before->Background->Scenario->After
  @SmokeTest @PlaceOrder
  Scenario Outline: Search  experience for product search in both home and offers page
    Given User is on GreenCart landing page
    When user seached with the shortname <Name> and extracted actual name
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items in checkout page
    And validate user has the promo code and place the order

    Examples:
      | Name |
      | Tom  |
      | Beet |
