import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.BasePage;
import page.BrowserFactory;

@Slf4j
public class BaseTest {
    public void takeScreenshotAndAttachToAllure() {
        byte[] screenshot = takeScreenshot();
        attachScreenshotToAllure(screenshot);
    }
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure(byte[] screenshot) {
        return screenshot;
    }
    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(){
        int width = Integer.parseInt(System.getProperty("browser.width"));
        int height = Integer.parseInt(System.getProperty("browser.height"));
        String browser = System.getProperty("browser.type");
        log.info("Tests will run at {}x{} in {} browser.", width, height, browser);
        WebDriver driver = BrowserFactory.getBrowserInstance(BrowserType.valueOf(browser));
        driver.get("https://demo.opencart.com/");
        driver.manage().window().setSize(new Dimension(width, height));
        BasePage.setDriverThreadLocal(driver);
//        int weidth = Integer.parseInt(System.getProperty("browser.width"));
//        int height = Integer.parseInt(System.getProperty("browser.height"));
//        String browser = System.getProperty("browser.type");
//        log.info("Test will run at {}x{} in {} browser.", weidth,height,browser);
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
//        WebDriver driver = BrowserFactory.getBrowserInstance(BrowserType.valueOf(browser));
//        driver.get("https://demo.opencart.com/");
//        driver.manage().window().setSize(new Dimension(weidth,height));
//        BasePage.setDriverThreadLocal(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void quite(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshotAndAttachToAllure();
        }
        BasePage.getDriver().quit();}
  }
