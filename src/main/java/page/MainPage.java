package page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class MainPage extends BasePage {
    @FindBy(xpath = "//a[text()='Brands']")
    private WebElement brandsLocator;
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement buttonMyAccount;
    @FindBy(xpath = "//*[@id='top']/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")
    private WebElement buttonLogin;
    @FindBy(xpath = "//*[text()='Desktops']")
    private WebElement narbarMenu;
    @FindBy(xpath = "//a[text()='Show All Desktops']")
    private WebElement showAllDesktops;
    @FindBy(xpath = "//span[text()='Currency']")
    private WebElement currency;
    @FindBy(xpath = "//*[@id='form-currency']/div/a/strong")
    private WebElement dollarSign;
    @FindBy(xpath = "//a[@href='USD']")
    private WebElement selectDollarSign;
    @FindBy(xpath = "//a[text()='iPhone']")
    private WebElement iPhone;
    @FindBy(xpath = "//a[text()='Cameras']")
    private WebElement cameras;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage checkCurrencyIsDollar() {
        if (!dollarSign.isDisplayed()) {
            currency.click();
            selectDollarSign.click();
        }
        return this;
    }

    public IphonePage clickIphone() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", iPhone);
        return new IphonePage();
    }

    public BrandsPage clickLinkBrands() {
        log.info("Clicking to link brands");
        JavascriptExecutor executor = (JavascriptExecutor) getDriverThreadLocal();
        executor.executeScript("arguments[0].click()", brandsLocator);
        return new BrandsPage();
    }

    public DesktopsPage clickButtonShowAllDesktop() {
        narbarMenu.click();
        showAllDesktops.click();
        return new DesktopsPage();
    }

    public LoginPage clickButtonMyAccount() {
        log.info("Clicking button my account");
        buttonMyAccount.click();
        buttonLogin.click();
        return new LoginPage();
    }

    public CamerasPage clickButtonCameras() {
        log.info("Clicking button Cameras");
        cameras.click();
        return new CamerasPage();
    }

}
