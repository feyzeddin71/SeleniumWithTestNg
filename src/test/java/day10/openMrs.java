package day10;

import Utilities.CommonUtils;
import Utilities.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class openMrs {
     /*
    ****Implement Page object model
      -Test classes
       -loginPage
       -DashboardPage
       -Register a patient
       *
    navigate https://demo.openmrs.org/openmrs/
    locate elements for login
     userName= admin
     password= Admin123
     Click inpatient ward
     click login button
     once you are logged in locate an element
     */

    WebDriver driver;
    loginPageMrs loginPageMrs;
    DashboardMrs DashboardMrs;
    registerMrs registerMrs;

    @BeforeMethod
    public void setup() {
        driver = WebDriverUtils.getDriver("chrome");
        loginPageMrs = new loginPageMrs(driver);
        DashboardMrs = new DashboardMrs(driver);
        registerMrs = new registerMrs(driver);

    }

    @AfterMethod

    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            CommonUtils.takeScreenShot(driver, result.getName());
        }
    }

    @Test
    public void pageObjectMrs() {
        driver.get(CommonUtils.
                readProperty("src/test/resources/credentials.properties", "url3"));
        //WebElement usernameField= driver.findElement(By.id("txtUsername"));
        loginPageMrs.usernameField.sendKeys("admin");
        loginPageMrs.passwordField.sendKeys("Admin123");
        loginPageMrs.InpatientWard.click();
        loginPageMrs.loginButton.click();

        String title= driver.getTitle();
        Assert.assertTrue(title.equals("Home"));

        DashboardMrs.clickRegisterButton.click();

        registerMrs.nameField.sendKeys("RenasTech");
    }
}
