import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.BasePage;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        BasePage.setDriver(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void quite(){
        BasePage.getDriver().quit();
    }
    @AfterMethod(alwaysRun = true)
    public void clear(){BasePage.getDriver().close();

    }
}
