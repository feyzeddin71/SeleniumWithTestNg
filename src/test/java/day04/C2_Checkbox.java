package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2_Checkbox {

    public static void main(String[] args) {

        /*
Navigate to https://courses.letskodeit.com/practice
click on BMW RADIO button
verify that its selected
Check Bmw, Benz, honda
validate that benz is selected
 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://courses.letskodeit.com/practice");

        WebElement clickBMW= driver.findElement(By.cssSelector("#bmwradio"));
        clickBMW.click();
        if(clickBMW.isSelected()){

            System.out.println("BMW IS SELECTED");
        }else{
            System.out.println("BMW IS NOT SELECTED");
        }


       driver.findElement(By.cssSelector("#bmwcheck")).click();
        driver.findElement(By.cssSelector("#benzcheck")).click();

        WebElement hondasel=driver.findElement(By.cssSelector("#hondacheck"));
        hondasel.click();

        if(hondasel.isSelected()){
            System.out.println("HONDA IS SELECTED");
        }else {
            System.out.println("HONDA IS NOT SELECTED");
        }

    }
}
