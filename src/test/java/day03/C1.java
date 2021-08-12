package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C1 {

    public static void main(String[] args) {

        /*

        There are two types of xpaths

        Relative xpath //TagName[@TagAttribute='tagValue']
        --//at the begining of the locator.
        --it is more flexible
        --when web elements changes, it might break

        Absolute xpath /html/body/div/div/div
        --from top to a specific element
        --single at the begining of the locator
        --absolute xpath is more reliaable since its starts from the top


         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        WebElement header=driver.findElement(By.xpath("/html/body/div/div/h1"));

        if(header.isDisplayed()){

            System.out.println("yay");
        } else{
            System.out.println("nay");
        }


    }
}
