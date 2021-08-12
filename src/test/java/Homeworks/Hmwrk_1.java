package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hmwrk_1 {
    /*-Go to https://www.etsy.com/
            -Maximize window
-Verify title
-Verify Current Url
-Go to https://www.amazon.com/
            -Verify title
-Verify Current Url
-Navigate Back
-Refresh
-Quit browser */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.etsy.com/");
        String ActualEtsyTitle= driver.getTitle();
        System.out.println("ActualEtsyTitle = " + ActualEtsyTitle);

        String ExpectedEtsyTitle="Etsy";

        if(ActualEtsyTitle.equals(ExpectedEtsyTitle)){

            System.out.println("The test for Etsy`s title passed");
        }else{
            System.out.println("The test for Etay`s title failed");
        }

        String currentURLforEtsy= driver.getCurrentUrl();
        System.out.println("currentURLforEtsy = " + currentURLforEtsy);


        driver.navigate().to("https://www.amazon.com/");
        String ActualTitleAmazon= driver.getTitle();
        System.out.println("ActualTitleAmazon = " + ActualTitleAmazon);

        String ExpectedTitleAmazon="Amazon";

        if(ActualTitleAmazon.equals(ExpectedTitleAmazon)){

            System.out.println("The test for Amazon`s title passed");
        }else{
            System.out.println("The test for Amazon`s title failed");
        }

        String currentURLAmazon= driver.getCurrentUrl();
        System.out.println("currentURLAmazon = " + currentURLAmazon);

        driver.navigate().back();

        Thread.sleep(4000);

        driver.navigate().refresh();

        driver.quit();


    }

}
