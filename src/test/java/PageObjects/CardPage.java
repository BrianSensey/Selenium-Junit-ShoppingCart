package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Variables and Locators
    protected static String cardNumber;
    protected static String cvv;
    protected static String expMonth;
    protected static String expYear;
    protected static String creditLimit;

    @FindBy(xpath = "//h4[1]") private WebElement lbl_cardNumber;
    @FindBy(xpath = "//h4[2]") private WebElement lbl_cvv;
    @FindBy(xpath = "//h4[3]") private WebElement lbl_expDate;
    @FindBy(xpath = "//h4[4]") private WebElement lbl_creditLimit;

    //Constructor
    public CardPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //Methods
    public  void windowsPosition(){
        Set<String> identifiers = driver.getWindowHandles();
        for (String identifier: identifiers){
            driver.switchTo().window(identifier);
        }
    }

    public  void windowsFirstPosition(){
        driver.close();
        driver.switchTo().window("");
    }

    public  void getCardNumber(){
        wait.until(ExpectedConditions.elementToBeClickable(lbl_cardNumber));
        System.out.println(lbl_cardNumber.getText().replace("Card Number:- ",""));
        cardNumber = lbl_cardNumber.getText().replace("Card Number:- ","");
    }

    public  void getCVV(){
        wait.until(ExpectedConditions.elementToBeClickable(lbl_cvv));
        System.out.println(lbl_cvv.getText().replace("CVV:- ",""));
        cvv = lbl_cvv.getText().replace("CVV:- ","");
    }

    public  void getExpDate(){
        wait.until(ExpectedConditions.elementToBeClickable(lbl_expDate));
        System.out.println(lbl_expDate.getText().replace("Exp:- ",""));
        String expDate []=lbl_expDate.getText().replace("Exp:- ","").split("/");
        expMonth = expDate[0];
        expYear = expDate[1];
    }

    public  void getCreditLimit(){
        wait.until(ExpectedConditions.elementToBeClickable(lbl_creditLimit));
        System.out.println(lbl_creditLimit.getText().replace("Credit Limit ",""));
        creditLimit = lbl_creditLimit.getText().replace("Credit Limit ","");
    }
}
