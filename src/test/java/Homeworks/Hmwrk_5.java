package Homeworks;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hmwrk_5 {

    /*
    1.Navigate to https://demo.openmrs.org/
2.enter login credentials username="admin", password="Admin123"
3.click Inpatient Ward
4. click login
5. Click register a patient button
6.fill out the Form(Demographics, Contact info,Relationship) using given data in "patient info" using Data Provider from TestNG
 */

    WebDriver driver=null;

    @BeforeMethod
    public void beforeSetup (){

        driver= WebDriverUtils.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterSetup (){

        //driver.close();
    }

    public void login2(){

        driver.get("https://demo.openmrs.org/");

        WebElement usernameBox= driver.findElement(By.xpath("//*[@class='form-control form-control-sm form-control-lg form-control-md']"));
        usernameBox.sendKeys("admin");

        WebElement passwordBox= driver.findElement(By.cssSelector("#password"));
        passwordBox.sendKeys("Admin123");

        WebElement clickImpatientWard=driver.findElement(By.xpath("//li[@id='Inpatient Ward']"));
        clickImpatientWard.click();

        WebElement login= driver.findElement(By.xpath("//input[@id='loginButton']"));
        login.click();

        WebElement register= driver.findElement(By.xpath("//a[contains(@id,  '-registerPatient')]"));
        register.click();
    }

    @Test
    public void registerPatient(String name, String surname, String gender, String birthdate, String adress, String phone,
                                String relationship ){

login2();

WebElement pName= driver.findElement(By.xpath("//*[@id='fr3957-field']"));
pName.sendKeys(name);

WebElement pSurname= driver.findElement(By.xpath("//*[@id='fr1738-field']"));
pSurname.sendKeys(surname);

WebElement nextButton= driver.findElement(By.xpath("//*[@id='next-button']"));
nextButton.click();

WebElement pGender= driver.findElement(By.xpath("uhhj"));

    }
}
