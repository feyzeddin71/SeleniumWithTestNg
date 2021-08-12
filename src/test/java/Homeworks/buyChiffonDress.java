package Homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class buyChiffonDress {
    public buyChiffonDress(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath ="//*[@href='http://automationpractice.com/index.php?id_category=3&controller=category'][1]" )
    public WebElement clickWomen;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[2]/a")
    public WebElement clickDresses;

    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[3]/a")
    public WebElement clickSummerDresses;

    @FindBy(xpath = "//*[@id=\"selectProductSort\"]")
    public WebElement sortPriceLowest;

    @FindBy(xpath = "//*[@id=\"layered_id_attribute_group_16\"]")
    public WebElement chooseColorYellow;

    @FindBy(xpath = "//*[@id=\"layered_price_slider\"]/a[2]")
    public WebElement sliding;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/h5/a")
    public WebElement clickPrintedChiffonDress;

    @FindBy(xpath = "//*[@id=\"reduction_percent_display\"]")
    public WebElement discount;

    @FindBy(xpath = "//*[@id=\"our_price_display\"]")
    public WebElement actualPrice;

    @FindBy(xpath = "//*[@id='add_to_cart']")
    public WebElement clickAddToCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    public WebElement addedValidation;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    public WebElement proceedToCheckOut;

    @FindBy(xpath = "//*[ text()='Printed Chiffon Dress']")
    public WebElement theDressAppear;

    @FindBy(xpath = "//span[@id='total_price']")
    public WebElement TotalPricer;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    public WebElement getProceedToCheckOut1;






}
