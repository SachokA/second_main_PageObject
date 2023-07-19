package page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Slf4j
public class ForgottenPasswordPage extends BasePage {

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement inputEmailNew;
    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement buttonContinue;
    @FindBy(xpath = "//*[contains(text(),'Warning: The E-Mail Address was not found in our records!')]")
    private WebElement alert;

    public ForgottenPasswordPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ForgottenPasswordPage fullInputEmail() {
        log.info("Fulling input email");
        inputEmailNew.sendKeys("awdasds@dfg.uo");
        return this;
    }

    public ForgottenPasswordPage buttonClickContinue() {
        log.info("Clicking button continue");
        buttonContinue.click();
        return this;
    }

    public String alertMessage() {
        log.info("Checking alert message");
        waitUntilPresent(alert, 10);
        return alert.getText();
    }

}
