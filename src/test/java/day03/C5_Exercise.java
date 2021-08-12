package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C5_Exercise {

    public static void main(String[] args) throws InterruptedException {
        /*
navigate to herokuapp
click AddRemoveElements
Click Add button
Check if Delete button is displayed using an if statement
 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Add/Remove Elements")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@onclick='addElement()'] ")).click();

        WebElement delete=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (delete.isDisplayed()){
            System.out.println("Yay!");
        }else{
            System.out.println("Nah");
        }


    }
}
