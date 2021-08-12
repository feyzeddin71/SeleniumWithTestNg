package day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageMrs {
    public loginPageMrs(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@class='form-control form-control-sm form-control-lg form-control-md'][1]")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@class='form-control form-control-sm form-control-lg form-control-md' and @ id='password']")
    public  WebElement passwordField;

    @FindBy(id = "Inpatient Ward")
    public WebElement InpatientWard;

    @FindBy(xpath = "//*[@class='btn confirm']")
    public WebElement loginButton;
}
