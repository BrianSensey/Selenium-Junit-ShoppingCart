package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyPaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Variables and Locators
    @FindBy(xpath = "//h2") private WebElement txt_successfulMsg;
    @FindBy(xpath = "//td[2]/h3/strong") private WebElement lbl_orderID;

    //Constructor
    public VerifyPaymentPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //Methods
    public  void successfulMessage(String successfulMessage){
        wait.until(ExpectedConditions.elementToBeClickable(txt_successfulMsg));
        Assert.assertEquals(successfulMessage,txt_successfulMsg.getText());
        System.out.println(txt_successfulMsg.getText());
    }

    public  void orderID(){
        wait.until(ExpectedConditions.visibilityOf(lbl_orderID));
        Assert.assertTrue(lbl_orderID.isDisplayed());
    }
}
