package page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Slf4j
public class IphonePage extends BasePage {
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
    public IphonePage() {PageFactory.initElements(getDriver(), this);}
    public void changedCurrencyEuro() {
        log.info("Changed currency euro");
        currency.click();
        currencyEuro.click();
    }
    public void changedCurrencyPound() {
        log.info("Changed currency Pound");
        currency.click();
        currencyPound.click();
    }
    public String getPriceIphoneDollar() {

        log.info("Getting price iphone dollar");
        return iPhonePriceDollar.getText().substring(1);
    }
    public String getPriceIphoneEuro() {
        log.info("Getting price iphone euro");
        return iPhonePriceEuro.getText().replace("€","");
    }
    public String getPriceIphoneDPound() {
        log.info("Getting price iphone pound");
        return iPhonePricePound.getText().substring(1);
    }


}
