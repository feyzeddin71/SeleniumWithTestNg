package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C3 {
    public static void main(String[] args) {

        //and/or xpath

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.etsy.com");

        WebElement searchFiled=driver.findElement(By.xpath("//input[@data-id='search-query' or @type='text']"));
        searchFiled.sendKeys("gifts for me"+ Keys.ENTER);

        WebElement searchButton= driver.findElement(By.xpath("//button[@type='submit' and @aria-label='Search']"));
        searchButton.click();
    }
}
