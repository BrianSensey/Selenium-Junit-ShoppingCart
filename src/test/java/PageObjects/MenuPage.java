package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Variables and Locators
    @FindBy(xpath = "//nav/a[2]") private WebElement btn_generateCardNumber;

    //Constructor
    public MenuPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //Methods
    public  void clickGenerateCardNumber(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_generateCardNumber));
        btn_generateCardNumber.click();
    }
}
