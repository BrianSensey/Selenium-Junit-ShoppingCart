package Definitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartDefinitions {
    MenuPage menu;
    CardPage card;
    BuyProductPage buyProduct;
    UtilitarianPage utilitarian;
    PaymentPage payment;
    VerifyPaymentPage verifyPayment;

    //Constructor
    public CartDefinitions() {
        menu = new MenuPage(Hooks.driver);
        card = new CardPage(Hooks.driver);
        buyProduct = new BuyProductPage(Hooks.driver);
        utilitarian = new UtilitarianPage(Hooks.driver);
        payment = new PaymentPage(Hooks.driver);
        verifyPayment = new VerifyPaymentPage(Hooks.driver);
    }

    @Given("Web page is available")
    public void webPageIsAvailable() {
        Hooks.driver.get("http://demo.guru99.com/payment-gateway/index.php");
    }

    @When("The user generates a card number")
    public void theUserGeneratesACardNumber() {
        menu.clickGenerateCardNumber();
    }

    @And("The user gets card number")
    public void theUserGetsCardNumber() {
        card.windowsPosition();
        utilitarian.ScrollDown(200);
        card.getCardNumber();
        card.getCVV();
        card.getExpDate();
        card.getCreditLimit();
        card.windowsFirstPosition();
    }

    @And("The user buys a number of products {string}")
    public void theUserBuysANumberOfProducts(String quantity) {
        utilitarian.ScrollDown(200);
        buyProduct.chooseQuantity(quantity);
        buyProduct.buyNow();
    }

    @And("The user ends the payment process")
    public void theUserEndsThePaymentProcess() {
        utilitarian.ScrollDown(200);
        payment.setCardNumber();
        payment.setExpirationMonth();
        payment.setExpirationYear();
        payment.setCVV();
        payment.pay();
    }


    @Then("A successful message is displayed: {string}")
    public void aSuccessfulMessageIsDisplayed(String successfulMessage) {
        verifyPayment.successfulMessage(successfulMessage);
        verifyPayment.orderID();
    }
}


