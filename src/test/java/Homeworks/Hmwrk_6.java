package Homeworks;

import Utilities.WebDriverUtils;
import javafx.scene.effect.SepiaTone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Hmwrk_6 {

    /*
    Navigate to https://www.seleniumeasy.com/test/window-popup-modal-demo.html
Click Twitter button
Switch to pop window(it is not an alert)
fill out UserName and Password fields with Invalid data
validate error message
     */

    WebDriver driver=null;

    @BeforeMethod
    public void BeforeSetup(){

        driver= WebDriverUtils.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void AfterSetup(){

        //driver.close();
    }

    @Test
    public void PopUp() throws InterruptedException {

        driver.navigate().to("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

        WebElement cliclTwitter= driver.findElement(By.xpath("//*[@title='Follow @seleniumeasy on Twitter']"));
        cliclTwitter.click();

        String handle= driver.getWindowHandle();
        Set<String> handles= driver.getWindowHandles();

        String secondHandle="";

        for(String id:handles){
            if(!id.equals(handle)){

                secondHandle=id;

                driver.switchTo().window(secondHandle);
            }
        }
        Thread.sleep(3000);

        WebElement usernameBox= driver.findElement(By.xpath("//*[@autocapitalize='none'][1]"));
        usernameBox.sendKeys("7586758a");

        WebElement passwordBox= driver.findElement(By.xpath("//*[@name='session[password]']"));
        passwordBox.sendKeys("74fgugfu");

        driver.findElement(By.xpath("//*[@role='button' and @class='css-18t94o4 css-1dbjc4n r-urgr8i r-42olwf r-sdzlij r-1phboty r-rs99b7 r-ero68b r-vkv6oe r-1ny4l3l r-1fneopy r-o7ynqc r-6416eg r-lrvibr']")).click();

    WebElement errorMessage= driver.findElement(By.xpath("//*[@class='css-901oao r-18jsvk2 r-1qd0xha r-a023e6 r-16dba41 r-rjixqe r-bcqeeo r-qvutc0']"));

    System.out.println(errorMessage.getText());

        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
