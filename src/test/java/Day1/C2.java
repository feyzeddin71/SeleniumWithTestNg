package Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class C2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        String googleactualtitle= driver.getTitle();
        System.out.println(googleactualtitle);

        Thread.sleep(2000);


        /*Navigate class
        -navigate()

         */

        driver.navigate().to("https://www.facebook.com/");
        String facebookactualtitle= driver.getTitle();
        System.out.println(facebookactualtitle);

        Thread.sleep(3000);
        //will navigate to the previous page
        driver.navigate().back();

        Thread.sleep(3000);

        //will navigate previous page
        driver.navigate().forward();

        Thread.sleep(3000);

        //will refresh the page
        driver.navigate().refresh();

        driver.quit();

    }
}
