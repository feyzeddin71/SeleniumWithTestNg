package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C4_TagName {

    public static void main(String[] args) throws InterruptedException {


        //Locating By.tagName and ClassName

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");

        WebElement userName= driver.findElement(By.id("email"));
        userName.sendKeys("dhghgcfdsh");

        Thread.sleep(300);

        WebElement password= driver.findElement(By.id("pass"));
        password.sendKeys("23637ghfd");

        Thread.sleep(3000);

        WebElement login=driver.findElement(By.tagName("button"));

        login.click();

        WebElement errorMessage= driver.findElement(By.className("_9ay7"));

        if(errorMessage.isDisplayed()){

            System.out.println("your test is passed");
        } else{

            System.out.println("your test is failed");
        }
        driver.close();

    }
}
