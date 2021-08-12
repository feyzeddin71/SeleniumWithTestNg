package Homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAndBilling {
    public ShippingAndBilling(WebDriver driver) {PageFactory.initElements(driver, this ); }

    @FindBy(xpath = "//*[@id=\"address_invoice_form\"]/a/span")
    public WebElement validateAdress;

    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    public WebElement addComment;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    public WebElement checkOut;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]/div")
    public WebElement shippingCost;

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    public WebElement clickTerms;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    public WebElement checkOutAgain;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    public WebElement clickBankWire;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    public WebElement confirmOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong" )
    public WebElement orderDone;




}
