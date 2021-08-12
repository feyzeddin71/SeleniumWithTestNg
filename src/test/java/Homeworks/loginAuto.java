package Homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginAuto {
    public loginAuto(WebDriver driver){ PageFactory.initElements(driver,this); }

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=my-account'][1]")
    public WebElement clickSignIn;

    @FindBy(id = "email")
    public WebElement emailEnter;

    @FindBy(css = "#passwd")
    public WebElement passwordEnter;

    @FindBy(css = "#SubmitLogin")
    public WebElement clickSign;

    @FindBy(className = "info-account")
    public WebElement loginSuccessMessage;

    @FindBy(xpath = "//*[@class='alert alert-danger'][1]")
    public WebElement AuthenticationFailure;


}
