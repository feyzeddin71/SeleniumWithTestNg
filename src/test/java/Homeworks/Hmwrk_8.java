package Homeworks;

import Utilities.CommonUtils;
import Utilities.WebDriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Hmwrk_8 {

    /*-Use TestNg annotations
-Use DataProvider if it is necessary
-Implement different locator types
-Use Page Object Model
-Use TestNg.xml file as a runner
    Good Luck :)
    URL=“http://automationpractice.com/index.php”
            1)Register an Account with Valid Credentials
2)Register with multiple  Invalid Credentials using DataProvider
          */

    WebDriver driver;
    Actions actions;
    JavascriptExecutor js;
    registerAuto registerAuto;
    loginAuto loginAuto;
    buyChiffonDress buyChiffonDress;
    ShippingAndBilling ShippingAndBilling;

    @BeforeMethod
    public void BeforeSetUp (){

        driver= WebDriverUtils.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");

        actions=new Actions(driver);
        js= (JavascriptExecutor) driver;

        registerAuto =new registerAuto(driver);
        loginAuto=new loginAuto(driver);
        buyChiffonDress=new buyChiffonDress(driver);
        ShippingAndBilling =new ShippingAndBilling(driver);
    }

    @AfterMethod
    public void TearDown (ITestResult result){

        if(!result.isSuccess()){
            CommonUtils.takeScreenShot(driver,result.getName());
        }

        //driver.quit();
    }

    @Test
    public void register (){

        registerAuto.signInButton.click();
        registerAuto.enterEmail.sendKeys("feyzeddin71@gmail.com");
        registerAuto.createAccountButton.click();
        registerAuto.clickGenderMr.click();
        registerAuto.firstName.sendKeys("Feyzeddin");
        registerAuto.lastName.sendKeys("Donmez");
        registerAuto.password.sendKeys("Feyzeddin");


        Select select=new Select(registerAuto.selectDay);
        select.selectByIndex(5);

        Select select1=new Select(registerAuto.selectMonth);
        select1.selectByIndex(3);

        Select select2=new Select(registerAuto.selectYear);
        select2.selectByIndex(5);

        registerAuto.adress.sendKeys("514 Sussex Street");
        registerAuto.city.sendKeys("Jersey");

        Select select3=new Select(registerAuto.state);
        select3.selectByVisibleText("Kansas");

        registerAuto.zipCode.sendKeys("09489");

        Select select4=new Select(registerAuto.country);
        select4.selectByIndex(1);

        registerAuto.mobileNu.sendKeys("3185826012");
        registerAuto.alias.sendKeys("F35");
        registerAuto.registerButton.click();

    }
    /*
    3)Login with registered valid credentials
4)Login with multiple  Invalid Credentials using DataProvider
     */
    @Test
    public void login(){
        loginAuto.clickSignIn.click();
        loginAuto.emailEnter.sendKeys("feyzeddin71@gmail.com");
        loginAuto.passwordEnter.sendKeys("Feyzeddin");
        loginAuto.clickSign.click();

        System.out.println(loginAuto.loginSuccessMessage.getText());
        Assert.assertTrue(loginAuto.loginSuccessMessage.isDisplayed());
    }

    @Test(dataProvider="test1")
    public void Invalidlogin(String userName, String password){

        loginAuto.clickSignIn.click();
        loginAuto.emailEnter.sendKeys(userName);
        loginAuto.passwordEnter.sendKeys(password);
        loginAuto.clickSign.click();
        
        System.out.println(loginAuto.AuthenticationFailure.getText());

        Assert.assertTrue(loginAuto.AuthenticationFailure.isDisplayed());

    }
    @DataProvider(name="test1")
    public static Object [][] Invalidlogincredentials(){
        return new Object[][]{{"renas@gmail.com", "1234"},{"dotmam@gmail.com","whereareyou"},{"f35@hotmail.com","brokenkleg"}};
    }
    /*
    5)Buy a “Printed Chiffon Dress”
            1.Click Woman on the top
2.Click Dress
3.Choose Summer Dresses from the Categories
4.Sort By Cheapest First
5.Choose a Color
6.Change the Price Range to from $50 maximum to $40
7.Open “Printed Chiffon Dress” in a new window
8.Validate that Dress has 20 percent discount
9.Validate Actual price
10.Click “Add to cart” button
11.Validate that “Product successfully added to your shopping cart” appears.
12.Click “Proceed to Checkout” button
13.Validate that “Printed Chiffon Dress” appears on the card
14.Validate “TOTAL” amount
15.Click “Proceed to Check out”
     */

    @Test
    public void buyPChiffonDress () throws InterruptedException {
        login();
        buyChiffonDress.clickWomen.click();
        buyChiffonDress.clickDresses.click();
        buyChiffonDress.clickSummerDresses.click();

        Select select=new Select(buyChiffonDress.sortPriceLowest);
        select.selectByVisibleText("Price: Lowest first");

        buyChiffonDress.chooseColorYellow.click();

        actions.clickAndHold(buyChiffonDress.sliding).moveByOffset(20,0).perform();

        String firstWindowHandle=driver.getWindowHandle();
        Set<String> allWindowHandles= driver.getWindowHandles();
        String secondWindowHandle="";
        for(String each:allWindowHandles){
            if(!each.equals(firstWindowHandle)){
                secondWindowHandle=each;
                driver.switchTo().window(secondWindowHandle);
            }
        }
        buyChiffonDress.clickPrintedChiffonDress.click();

        buyChiffonDress.discount.click();
        System.out.println(buyChiffonDress.discount.getText());
        Assert.assertTrue(buyChiffonDress.discount.isDisplayed());

        buyChiffonDress.actualPrice.click();
        System.out.println(buyChiffonDress.actualPrice.getText());
        Assert.assertTrue(buyChiffonDress.actualPrice.isDisplayed());

        buyChiffonDress.clickAddToCart.click();

        buyChiffonDress.addedValidation.click();
        String addToCartValidation=buyChiffonDress.addedValidation.getText();
        System.out.println(addToCartValidation);
        Assert.assertTrue(addToCartValidation.contentEquals("Product successfully added to your shopping cart"));

        buyChiffonDress.proceedToCheckOut.click();

        //buyChiffonDress.theDressAppear.click();
        String PrintedPchiffonDressText=buyChiffonDress.theDressAppear.getText();
        System.out.println(PrintedPchiffonDressText);
        Assert.assertTrue(PrintedPchiffonDressText.contentEquals("Printed Chiffon Dress"));

        //js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);

        System.out.println(buyChiffonDress.TotalPricer.getText());
        Assert.assertTrue(buyChiffonDress.TotalPricer.getText().contentEquals("$18.40"));

        Thread.sleep(2000);

        buyChiffonDress.getProceedToCheckOut1.click();

    }
    /*
    16.Validate Delivery Address and Billing Address are matching
17.Click “Proceed to Check out”
            18.Add a comment
19.Click “Proceed to Check out”
            20.Choose a shipping option
21.Validate shipping cost
22.Click checkbox for Term and Services
23.Click “Proceed to Check out”
            23.Validate your order
24.Validate the total price
25.Click Pay by Bank wire
26.Click “I confirmm my Order” button
27.Validate that your order has completed.
     */

    @Test
    public void ShipBill() throws InterruptedException {

        buyPChiffonDress();

        String text=ShippingAndBilling.validateAdress.getText();
        Assert.assertTrue(text.isEmpty());

        ShippingAndBilling.addComment.sendKeys("Rest in Peace");

        ShippingAndBilling.checkOut.click();

        System.out.println(ShippingAndBilling.shippingCost.getText());
        Assert.assertTrue(ShippingAndBilling.shippingCost.getText().contentEquals("$2.00"));

        ShippingAndBilling.clickTerms.click();

        ShippingAndBilling.checkOutAgain.click();

        ShippingAndBilling.clickBankWire.click();

        ShippingAndBilling.confirmOrder.click();

        System.out.println(ShippingAndBilling.orderDone.getText());
        Assert.assertTrue(ShippingAndBilling.orderDone.getText().contentEquals("Your order on My Store is complete."));

    }





}
