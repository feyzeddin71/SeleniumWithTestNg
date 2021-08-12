package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2_IDLocater {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");

        WebElement password= driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");

        WebElement loginButton=driver.findElement(By.id("btnLogin"));

        loginButton.click();

    }
}
