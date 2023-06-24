package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage{
    @FindBy(xpath = "//a[text()='Brands']")
    private WebElement brandsLocator;

    @FindBy(xpath  = "//span[text()='My Account']")
    private WebElement buttonMyAccount;
    @FindBy(xpath  = "//*[@id='top']/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")
    private WebElement buttonLogin;

    @FindBy(xpath = "//*[@id='narbar-menu']/ul/li[1]/a")
    private WebElement narbarMenu;

    @FindBy(xpath = "//a[text()='Show All Desktops']")
    private WebElement showAllDesktops;

    @FindBy(xpath = "//span[text()='Currency']")
    private WebElement currency;

    @FindBy(xpath = "//*[@id='form-currency']/div/a/strong")
    private WebElement dollarSign;
    @FindBy(xpath = "//a[@href='USD']")
    private WebElement selectDollarSign;

    @FindBy(xpath ="//a[text()='iPhone']")
    private WebElement iPhone;

    @FindBy(xpath = "//a[text()='Cameras']")
    private WebElement  cameras;



    public MainPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public MainPage checkCurrencyIsDollar(){

        if (!dollarSign.isDisplayed()){
             currency.click();
             selectDollarSign.click();
        } return this;
    }

    public IphonePage clickIphone(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", iPhone);
//        iPhone.click();
        return new IphonePage();
    }

    public BrandsPage clickLinkBrands() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", brandsLocator);
        return new BrandsPage();
    }
    public DesktopsPage clickButtonShowAllDesktop(){
        narbarMenu.click();
        showAllDesktops.click();
        return new DesktopsPage();
    }
    public LoginPage clickButtonMyAccount(){
        buttonMyAccount.click();
        buttonLogin.click();
        return new LoginPage();
    }

    public CamerasPage clickButtonCameras(){
        cameras.click();
        return new CamerasPage();
    }





}
