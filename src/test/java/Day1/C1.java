package Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C1 {


    public static void main(String[] args) {

        /*

        Choosing the browser from WebDriverManager
         */

        WebDriverManager.chromedriver().setup();

        //create instance of chromedriver to be able to test things on chrome

        WebDriver driver=new ChromeDriver();

        //this method will maximize the window

        driver.manage().window().maximize();

        //get method will help us to navigate to a URL/URI

        driver.get("https://www.facebook.com/");

        //Validate title

        String actualTitle=driver.getTitle();
        System.out.println("facebook title is;"+ actualTitle);

        if(actualTitle.contains("Facebook")){
            System.out.println("Test is passed");
        } else{
            System.out.println("Test is failed");
        }

        //get url

        String currentUrl=driver.getCurrentUrl();
        System.out.println("The current url is"+ currentUrl);

        driver.close();

        //driver.close();will close the certain page



        // driver.quit();  will close all the pages, browser
        // Thread.sleep ();  comes after some time closes the page


    }
}
