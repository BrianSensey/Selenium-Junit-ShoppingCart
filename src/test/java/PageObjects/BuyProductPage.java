package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Variables and Locators
    @FindBy(xpath = "//select") private WebElement cbox_quantity;
    @FindBy(xpath = "//input") private WebElement btn_buyNow;

    //Constructor
    public BuyProductPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //Methods
    public  void chooseQuantity(String quantity){
        wait.until(ExpectedConditions.elementToBeClickable(cbox_quantity));
        new Select(cbox_quantity).selectByValue(quantity);
    }

    public  void buyNow(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_buyNow));
        btn_buyNow.click();
    }
}
