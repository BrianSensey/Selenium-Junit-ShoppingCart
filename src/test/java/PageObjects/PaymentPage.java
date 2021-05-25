package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;
    CardPage card;

    //Variables and Locators
    @FindBy(id = "card_nmuber") private WebElement tbox_cardNumber;
    @FindBy(id = "month") private WebElement cbox_expirationMonth;
    @FindBy(id = "year") private WebElement cbox_expirationYear;
    @FindBy(id = "cvv_code") private WebElement tbox_cvv;
    @FindBy(xpath = "//li/input") private WebElement btn_pay;

    //Constructor
    public PaymentPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //Methods
    public  void setCardNumber(){
        wait.until(ExpectedConditions.elementToBeClickable(tbox_cardNumber));
        tbox_cardNumber.sendKeys(card.cardNumber);
    }

    public  void setExpirationMonth(){
        wait.until(ExpectedConditions.elementToBeClickable(cbox_expirationMonth));
        new Select(cbox_expirationMonth).selectByVisibleText(card.expMonth);
    }

    public  void setExpirationYear(){
        wait.until(ExpectedConditions.elementToBeClickable(cbox_expirationYear));
        new Select(cbox_expirationYear).selectByValue(card.expYear);
    }

    public  void setCVV(){
        wait.until(ExpectedConditions.elementToBeClickable(tbox_cvv));
        tbox_cvv.sendKeys(card.cvv);
    }

    public  void pay(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_pay));
        btn_pay.click();
    }
}
