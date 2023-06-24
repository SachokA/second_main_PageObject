package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ForgottenPasswordPage extends BasePage {
    public ForgottenPasswordPage(){PageFactory.initElements(getDriver(),this);}

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement inputEmailNew;

    @FindBy(xpath =  "//button[text()='Continue']")
    private WebElement buttonContinue;
    @FindBy(xpath = "//*[contains(text(),'Warning: The E-Mail Address was not found in our records!')]")
    private WebElement alert;



    public ForgottenPasswordPage fullInputEmail(){
        inputEmailNew.sendKeys("awdasds@dfg.uo");
        return this;
    }
    public ForgottenPasswordPage buttonClickContinue(){
        buttonContinue.click();
        return this;
    }


//    public String alertMessage() {
////        WebDriverWait wait = new WebDriverWait(driver, 10);
////        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(alert));
//        waitUntilClickable((By) alert,10);
//        return alert.getText();
//    }
public String alertMessage() {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    WebElement alertMessage = wait.until(ExpectedConditions.visibilityOf(alert));
    return alertMessage.getText();


}

}
