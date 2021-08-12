package Homeworks;

import Utilities.WebDriverUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hmwrk_7 {
    /*
    Task 1
Navigate to http://the-internet.herokuapp.com/
Click Hovers
Validate the text under Image 1
     */

    WebDriver driver = null;
    Actions actions = null;
    Alert alert = null;

    @BeforeMethod
    public void BeforeSetUp() {

        driver = WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        actions= new Actions(driver);
    }

    @AfterMethod
    public void AfterSetUp(){

        //driver.close();
    }

    @Test
    public void Hovers(){
        driver.get("http://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//*[@href='/hovers']")).click();

        WebElement FirstImage= driver.findElement(By.xpath("//h5[.='name: user1']/../preceding-sibling::img"));
        actions.moveToElement(FirstImage).perform();

        WebElement ImageText= driver.findElement(By.xpath("//h5[.='name: user1']"));

        System.out.println(ImageText.getText());
        Assert.assertTrue(ImageText.isDisplayed());
    }
/*
    Task 2
    Navigate to http://the-internet.herokuapp.com/
    Click HorizontalSlider
    Move the slider to the middle

 */
    @Test
    public void Slider() throws InterruptedException {

        driver.navigate().to("http://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//*[@href='/horizontal_slider']")).click();

        WebElement HorizSlider= driver.findElement(By.xpath("//*[@type='range']"));
        actions.clickAndHold(HorizSlider).moveByOffset(6,0).perform();

    }


}
