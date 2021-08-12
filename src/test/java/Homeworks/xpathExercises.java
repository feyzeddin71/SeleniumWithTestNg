package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathExercises {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/ ");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//body[contains(@class, 'aui_csa_templates_declarative_ww_launch_337520')]")).click();

        driver.findElement(By.xpath("//input[contains(@type, 'em')]"));
        driver.findElement(By.xpath("//a[contains(@href, '.openid')]")).click();


        }
    }



