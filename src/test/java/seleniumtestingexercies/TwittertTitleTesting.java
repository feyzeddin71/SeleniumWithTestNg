package seleniumtestingexercies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwittertTitleTesting {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.twitter.com/");

        String actualTitle= driver.getTitle();
        System.out.println("Twitter`s actual title is "+ actualTitle);

        if(actualTitle.contains("Twitter")){

            System.out.println("Test is passed");
        } else{
            System.out.println("Test is failed");
        }

        driver.close();

    }
}
