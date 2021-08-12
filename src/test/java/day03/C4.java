package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class C4 {

    public static void main(String[] args) {

        //Contains method in xpath

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.findElement(By.xpath("//input[contains(@id,'tw')]"))
                .sendKeys("Books"+ Keys.ENTER);




    }
}
