package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IphonePage extends BasePage {
    public IphonePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='$123.20']")
    private WebElement iPhonePriceDollar;

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]/ul[2]/li[1]/h2/span")
    private WebElement iPhonePriceEuro;

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]/ul[2]/li[1]/h2/span")
    private WebElement iPhonePricePound;

    @FindBy(xpath = "//a[text()='€ Euro']")
    private WebElement currencyEuro;

    @FindBy(xpath ="//*[@id='form-currency']/div/ul/li[2]/a" )
    private WebElement currencyPound;

    @FindBy(xpath = "//span[text()='Currency']")
    private WebElement currency;


    public void changedCurrencyEuro() {
        currency.click();
        currencyEuro.click();
    }
    public void changedCurrencyPound() {
        currency.click();
        currencyPound.click();
    }
    public String getPriceIphoneDollar() {
        return iPhonePriceDollar.getText().substring(1);
    }
    public String getPriceIphoneEuro() {
        return iPhonePriceEuro.getText().replace("€","");
    }
    public String getPriceIphoneDPound() {
        return iPhonePricePound.getText().substring(1);
    }


}
