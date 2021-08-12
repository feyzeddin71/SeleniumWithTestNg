package day04;

import Utilities.WebDriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C4 {

    public static void main(String[] args) throws InterruptedException {
        /*
Navigate to Etsy.com
Find  Search button and click
Click ShipIn1Day
and verify that it is selected
Click ShipIn3Days
and Verify that it is selected
 */


        WebDriver driver = WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.etsy.com/");

        driver.findElement(By.xpath("//button[@type='submit'][1]")).click();
        Thread.sleep(2000);

        WebElement SHIP1 = driver.findElement(By.xpath("//label[@for='max-processing-days-1']/preceding-sibling::input"));

        if (SHIP1.isEnabled()) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        Thread.sleep(2000);

        WebElement SHIP3 = driver.findElement(By.xpath("//label[@for='max-processing-days-3']/preceding-sibling::input"));

        if (SHIP3.isEnabled()) {
            System.out.println("passed");
        } else {
            System.out.println("failed");


        }
    }
}
