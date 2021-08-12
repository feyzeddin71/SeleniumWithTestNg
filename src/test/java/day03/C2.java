package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2 {

    public static void main(String[] args) {

        /*
        Navigate to https://the-internet.herokuapp.com/
        click forgot password
        fill out email field
        click retrieve password field


         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement forgtpassword = driver.findElement(By.xpath("//a [@href='/forgot_password']"));
        forgtpassword.click();

        WebElement fillemailfield = driver.findElement(By.xpath("//input[@type='text']"));
        fillemailfield.sendKeys("feyzo");

        WebElement cliclkretrieve = driver.findElement(By.xpath("//i[@ class='icon-2x icon-signin']"));
        cliclkretrieve.click();

        WebElement header = driver.findElement(By.tagName("h1"));

        String actualtitle = header.getText();
        String expectedtitle = "Internal Server Error";

        if (actualtitle.equals(expectedtitle)) {
            System.out.println("yay");
        } else {
            System.out.println("nay");

        }
    }
}
