package day06;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C2 {
//1- Open a chrome browser
    //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3- Enter username --->Tester
    //4- Enter password --->test
    //5- Click "Login" button
    //6- Verify title equals: Web Orders

    WebDriver driver=null;

    @BeforeMethod
    public void beforeSetup(){

        driver= WebDriverUtils.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @AfterMethod
    public void afterSetup (){

        driver.close();
    }

    public void login(){

        WebElement usernameBox= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        WebElement passwordBox= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        usernameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");

        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

    @Test
    public void smartbearLogin (){

        login();

        String title= driver.getTitle();
        Assert.assertTrue(title.equalsIgnoreCase("Web orders"));


    }

    /*
    Smartbear software street verification
      1. Open browser and login to Smartbear software
      2. Click on View all orders
      3. Verify Mark Smith has street as  "9, Maple Valley"
    */

    @Test
    public void smartBearStreetVerification(){
        //1)Open browser and login to Smartbear software

        login();

        //2. Click on View all orders

        WebElement viewAllOrder= driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        viewAllOrder.click();

        //3. Verify Mark Smith has street as  "9, Maple Valley"

        WebElement smithAdress=driver.findElement(By.xpath("//td[text()='Mark Smith']/following-sibling::td[4]"));
        Assert.assertTrue(smithAdress.getText().equalsIgnoreCase("9, Maple Valley"));
    }


}
