package Homeworks;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Hmwrk_3 {
    /*1)Navigate to http://the-internet.herokuapp.com/
2)Validate  page title
3)Validate  page url
4)Click Checkboxes
5)Change Checkbox 1 to “Checked”
6)Validate that its “checked”
7)Change Checkbox 2 to “Unchecked”
8)Validate that Checkbox 2 is “Unchecked”
9)Navigate Back to //the-internet.herokuapp.com/ main page
10)Click Dropdown
11)Choose “Option 2” from the drop down
12)Close the browser */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://the-internet.herokuapp.com/");

        String pagetitle = driver.getTitle();
        if (pagetitle.contains("hero")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        System.out.println("Page title is : " + pagetitle);

        String PageUrl = driver.getCurrentUrl();

        if (PageUrl.equals("http://the-internet.herokuapp.com/")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        System.out.println("Page`s URL is : " + PageUrl);

        driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();

        Thread.sleep(2000);

        WebElement checked1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        checked1.click();

        if (checked1.isSelected()) {
            System.out.println("The first box is Checked");
        } else {
            System.out.println("The first box is Unchecked");}

            Thread.sleep(2000);


           WebElement unchecked2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
            unchecked2.click();

            if (!unchecked2.isSelected()) {
                System.out.println("The second box is Unchecked");

            } else {
                System.out.println("The second box is checked");

            }

            Thread.sleep(2000);

            driver.navigate().back();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//a[@href='/dropdown']")).click();

            Thread.sleep(200);

            WebElement dropDown=driver.findElement(By.xpath("//select [@id='dropdown']"));

            Select select=new Select(dropDown);
            select.selectByVisibleText("Option 2");

            Thread.sleep(2000);

            driver.close();



        }

    }
