Feature: Search and Place the order for products
  @RegressionTest @OffersPage
  Scenario Outline: Search  experience for product search in both home and offers page
    Given User is on GreenCart landing page
    When user seached with the shortname <Name> and extracted actual name
    Then user searched for <Name>  shortname in offers page
    And validate product name in offers page matches with landing page

    Examples:
    | Name |
    | Tom  |
    | Beet |
