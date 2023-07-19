import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.BasePage;

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
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        BasePage.setDriver(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void quite(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshotAndAttachToAllure();
        }
        BasePage.getDriver().quit();}
  }
