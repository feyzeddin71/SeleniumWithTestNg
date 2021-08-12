package Homeworks;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hmwrk_4 {
    /*
    1- Open a chrome browser
      2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
      3- Login(username=Tester, password=test)
         -Create a Login method and call it into your @Test
      4. Click on Order
      5. Select familyAlbum from product,
           set quantity to 5
      6. Click to “Calculate” button
      7. Fill address Info with @DataProvider method from TestNG
      8. Click on “visa” radio button
      9. Generate card number using @DataProvider
     10.Enter expiration date
     11. Click on “Process”
    12.Verify success message “New order has been successfully added.” is displayed.
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

    public void login(){

     driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement usernameBox= driver.findElement(By.xpath("//*[@name='ctl00$MainContent$username']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox= driver.findElement(By.xpath("//*[@name='ctl00$MainContent$password']"));
        passwordBox.sendKeys("test");

        WebElement loginButton=driver.findElement(By.xpath("//*[@type='submit']"));
        loginButton.click();

        WebElement clickonOrder= driver.findElement(By.xpath("//*[@href='Process.aspx']"));
        clickonOrder.click();

    }


    @Test(dataProvider = "test1")

        public void adressInformation(String name, String street, String city, String state, String zipcode, String credit, String expiration){

        login();

        WebElement dropdown=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("FamilyAlbum");

        WebElement setQuantity=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        setQuantity.clear();
        setQuantity.sendKeys("5");

        WebElement calculate=driver.findElement(By.xpath("//*[@type='submit']"));
        calculate.click();

            WebElement custName= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
            custName.sendKeys(name);

            WebElement cusstreet= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
            cusstreet.sendKeys(street);

            WebElement cuscity= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
            cuscity.sendKeys(city);

            WebElement cusstate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
            cusstate.sendKeys(state);

            WebElement cuszipcode= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
            cuszipcode.sendKeys(zipcode);

        WebElement visaClick= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0"));
        visaClick.click();

        WebElement cuscardNumber= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cuscardNumber.sendKeys(credit);

        WebElement cusexpirationDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        cusexpirationDate.sendKeys(expiration);

        WebElement processIt= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        processIt.click();

        WebElement orderDoneMessage= driver.findElement(By.tagName("strong"));

        Assert.assertTrue(orderDoneMessage.isDisplayed());
        System.out.println(orderDoneMessage.getText());


        }



    @DataProvider(name="test1")
    public static Object [][] adressCredentials (){

        return new Object[][]{{"Feyzeddin", "200 Sussex Street", "Jersey","NJ","07029","7624276", "09/23"}};


    }

}
