Feature: Buy product in the Shopping Cart
  As a customer user
  I like to buy a new product entering confidential information

  @Test
  Scenario: 1. Buy product
    Given Web page is available
    When The user generates a card number
    And The user gets card number
    And The user buys a number of products "9"
    And The user ends the payment process
    Then A successful message is displayed: "Payment successful!"