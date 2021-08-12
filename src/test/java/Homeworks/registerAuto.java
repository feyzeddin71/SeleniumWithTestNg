package Homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerAuto {
    public registerAuto(WebDriver driver){ PageFactory.initElements(driver,this); }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

    @FindBy(css = "#email_create")
    public WebElement enterEmail;

    @FindBy(css = "#SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(css = "#id_gender1")
    public WebElement clickGenderMr;

    @FindBy(name = "customer_firstname")
    public WebElement firstName;

    @FindBy(css = "#customer_lastname")
    public WebElement lastName;

    @FindBy(css = "#passwd")
    public WebElement password;

    @FindBy(css = "#days")
    public WebElement selectDay;

    @FindBy(xpath = "//*[@id='months' and @name='months']")
    public WebElement selectMonth;

    @FindBy(css = "#years")
    public WebElement selectYear;

    @FindBy(name = "address1")
    public WebElement adress;

    @FindBy(css = "#city")
    public WebElement city;

    @FindBy(css = "#id_state")
    public WebElement state;

    @FindBy(css = "#postcode")
    public WebElement zipCode;

    @FindBy(css = "#id_country")
    public WebElement country;

    @FindBy(css = "#phone_mobile")
    public WebElement mobileNu;

    @FindBy(css = "#alias")
    public WebElement alias;

    @FindBy(css = "#submitAccount")
    public WebElement registerButton;

    @FindBy()
    public WebElement registerSuccessMessage;





}
