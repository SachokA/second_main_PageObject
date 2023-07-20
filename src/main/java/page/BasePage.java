package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public abstract class BasePage {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    public static ThreadLocal<WebDriver> getDriverThreadLocal(){
        return DRIVER_THREAD_LOCAL;
    }
    public static void setDriverThreadLocal(WebDriver webDriver){
        DRIVER_THREAD_LOCAL.set(webDriver);
    }
    protected WebElement waitUntilPresent(WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void select(WebElement webElement, String value){
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }
    public List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }
//    protected static WebDriver driver;
    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }
 //
}
