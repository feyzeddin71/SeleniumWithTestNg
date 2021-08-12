package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverUtils {




        public static WebDriver getDriver(String browser){

            //This method will accept string value
            //this will return Webdriver

            if(browser.equalsIgnoreCase("chrome")){

                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }else if(browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }else if(browser.equalsIgnoreCase("iedriver")){
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            }else{
                System.out.println("Browser does not exist");
                System.out.println("please check the browser name");
                System.out.println("current browser name is "+browser);
                return null;
            }
        }

}
