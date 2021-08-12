package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C1_CSS_SELECTOR {

    public static void main(String[] args) {


        /*
        Css
        -is the fastest locator
        -By.c
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/ ");

        WebElement searchField= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchField.sendKeys("sestgdsgs");

        WebElement searchButton= driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();
    }
}
