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

public class C3 {

    /*
    Navigate to "http://the-internet.herokuapp.com/iframe"
    Clean the text field
    Type "Hello it's me" to the text field
    Validate the title
     */

    WebDriver driver = null;

    @BeforeMethod
    public void beforeSetup() {

        driver = WebDriverUtils.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void afterSetup() {

        //driver.close();
    }

    @Test
    public void iframes() {
        /*
          In order to interact with elements within an iframe, one needs to
          locate the iframe first by using locators
          and then SWITCH to the iframe
        */

        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        WebElement messageBox = driver.findElement(By.id("tinymce"));
        messageBox.clear();
        messageBox.sendKeys("Hello, it is me");

        //driver.switchTo().parentFrame();// returns to  previous iframe or html block
        // driver.switchTo().defaultContent();// returns to the main html

        driver.switchTo().defaultContent();// returns to the main html
        System.out.println(driver.getTitle());

    }

    /*
  Navigate to http://the-internet.herokuapp.com/nested_frames
  Switch to other frames
   */
    @Test
    public void nestedIframes() throws InterruptedException {

        driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");

        Thread.sleep(2000);

        driver.switchTo().frame("frame-top");
        Thread.sleep(2000);
        driver.switchTo().frame(0);

        WebElement getIframeText = driver.findElement(By.tagName("body"));
        System.out.println(getIframeText.getText());
        Assert.assertFalse(!getIframeText.getText().equalsIgnoreCase("left"));
        Assert.assertTrue(getIframeText.getText().equalsIgnoreCase("left"));

    }

    @Test
    public void buttomIframe() throws InterruptedException {

        /*
        -locate the buttom iframe
        -validate the text and print out
         */

        driver.get("http://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(2000);

        driver.switchTo().frame("frame-bottom");

        WebElement ButtomIFrameText= driver.findElement(By.tagName("body"));

        System.out.println( ButtomIFrameText.getText());


    }
}