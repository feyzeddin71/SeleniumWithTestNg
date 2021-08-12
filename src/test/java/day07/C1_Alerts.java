package day07;

import Utilities.WebDriverUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class C1_Alerts {

    WebDriver driver= null;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void jsAlert() throws InterruptedException {

        driver.navigate().to("http://the-internet.herokuapp.com/");

        //Action helps us to do all the keyboard and mouse action

        WebElement javaScriptAlert= driver.findElement(By.xpath("//*[@href='/javascript_alerts']"));

        String mainPageurl=driver.getCurrentUrl();
        System.out.println(mainPageurl);

        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).click(javaScriptAlert).keyUp(Keys.SHIFT).build().perform();

        /*
       Window Handles are unique identifiers of different windows, tabs.
       In order to switch from one window to anther we need to use window handles
        */

        String firstWIndowHandle= driver.getWindowHandle();

        //We store multiple window handles in Set<String>

        Set<String> allWindowHandles=driver.getWindowHandles();

        String secondWindowHandle="";

        // for loop helps us to compare window handles

        for (String id:allWindowHandles){
            if(!id.equals(firstWIndowHandle)){
                secondWindowHandle=id;
                //it will switch to window
                driver.switchTo().window(secondWindowHandle);
            }
        }

        String url= driver.getCurrentUrl();
        System.out.println(url);

        WebElement jsAlert= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();

        Thread.sleep(3000);

        Alert alert= driver.switchTo().alert();

        driver.switchTo().alert().accept();

       /*
       ALERT HANDLING METHODS
       driver.SwitchTp().alert()...
       Accept
       Dismiss
       getText()
       SendKeys()
        */
    }

    @Test
    public void jsConfirmOkay() throws InterruptedException {
        driver.navigate().to("http://the-internet.herokuapp.com/");

        WebElement javaScriptAlert= driver.findElement(By.xpath("//*[@href='/javascript_alerts']"));
        javaScriptAlert.click();

        WebElement clickJsConfirm= driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
        clickJsConfirm.click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        WebElement okayText= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(okayText.getText().contains("Ok"));
    }

    @Test
    public void jsConfirmCancel(){
        /*
        Go to "http://the-internet.herokuapp.com/"
        click JavaScript Alerts
        click js Confirm
        Click Cancel
        Validate text
         */
        driver.navigate().to("http://the-internet.herokuapp.com/");

        WebElement javaScriptAlert= driver.findElement(By.xpath("//*[@href='/javascript_alerts']"));
        javaScriptAlert.click();

        WebElement clickJsConfirm= driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
        clickJsConfirm.click();

        Alert alert=driver.switchTo().alert();
        alert.dismiss();

        WebElement actualText= driver.findElement(By.xpath("//p[@id='result']"));
        String expectedText= "You clicked: Cancel";

        Assert.assertFalse(actualText.getText().contains("Ok"));
        Assert.assertTrue(actualText.getText().contains("Cancel"));
        Assert.assertEquals(actualText.getText(),expectedText);
    }

    @Test
    public void jsPromptAlert() throws InterruptedException {
        /*
         Go to "http://the-internet.herokuapp.com/"
         click JavaScript Alerts
         Click for Js Prompt
         Enter "I love this game" text
         Click okay
         Validate your text appearing on the page
         */
        driver.navigate().to("http://the-internet.herokuapp.com/");

        WebElement javaScriptAlert= driver.findElement(By.xpath("//*[@href='/javascript_alerts']"));
        javaScriptAlert.click();

        WebElement clickJsConfirm= driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
        clickJsConfirm.click();

        Alert alert= driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("I love this game");
        Thread.sleep(2000);
        alert.accept();

        WebElement actualText= driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(actualText.getText().contains("I love"));
    }

    // alert or window pop ups mean same thing
    @Test
    public void basicAuthorizationAlert() throws InterruptedException {

        /*
    We can simply provide userName and password within url
     */
        //http://username:password@domain.com
        driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement congratsText= driver.findElement(By.tagName("p"));
        Assert.assertTrue(congratsText.getText().contains("Congratulations"));

    }






    }

