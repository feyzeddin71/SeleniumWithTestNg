package day05;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C2_GooglePractice {

    /*
    -Navigate to Google
    -Validate the title
    -Locate the search field
    -Search "Renastech"
    -close the browser
     */
WebDriver driver=null;

@BeforeMethod

    public void setup(){

    driver=WebDriverUtils.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.google.com/");
}

@AfterMethod

    public void tearDown(){

    driver.close();
}

@Test(priority = 3)

    public void googleSearch() throws InterruptedException {

    String actualTitle= driver.getTitle();
    Assert.assertTrue(actualTitle.equalsIgnoreCase("google"));

    WebElement searchButton= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
    Thread.sleep(2000);
    searchButton.sendKeys("Feyzeddin Donmez"+ Keys.ENTER);
    Thread.sleep(200);
}

@Test(priority = 1)

    public void googleSearch1() throws InterruptedException {

    WebElement searchButton= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
    Thread.sleep(2000);
    searchButton.sendKeys("Kurdistan"+ Keys.ENTER);
    Thread.sleep(200);
}

@Test(priority = 2)

    public void googleSearch2() throws InterruptedException {

    WebElement searchButton= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
    Thread.sleep(2000);
    searchButton.sendKeys("Mus"+ Keys.ENTER);
    Thread.sleep(200);
}


}
