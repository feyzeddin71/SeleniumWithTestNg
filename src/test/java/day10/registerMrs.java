package day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerMrs {

    public registerMrs(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "givenName")
    public WebElement nameField;
}
