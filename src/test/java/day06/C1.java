package day06;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C1 {
    //1- Open a chrome browser
//2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3- Enter INVALID username
//4- Enter INVALID password
//5- Click "Login" button
//6- Verify THE ERROR message

    WebDriver driver=null;

    @BeforeMethod
    public void beforeSetup(){
        driver= WebDriverUtils.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterSetup(){

        driver.close();
    }

    @Test(dataProvider = "test1")
    public void loginSmartbear(String userName, String password){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement usernameBox= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        WebElement passwordBox= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        usernameBox.sendKeys(userName);
        passwordBox.sendKeys(password);

        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement errorMessage=driver.findElement(By.xpath("//span[@id='ctl00_MainContent_status']"));
        String invalidMessage=errorMessage.getText();

        Assert.assertEquals(invalidMessage,"Invalid Login or Password.");
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @DataProvider(name = "test1")
    public static Object [][] loginCredentials(){

        return new Object[][] {{"yes","no"},{"nay","yay"},{"admin","admin123"}};
    }




}
