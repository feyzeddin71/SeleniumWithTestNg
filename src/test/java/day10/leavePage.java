package day10;

import Utilities.CommonUtils;
import Utilities.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class leavePage {

    public leavePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='/index.php/leave/assignLeave' and text()='Assign Leave']")
    public WebElement assignLeave;

}
