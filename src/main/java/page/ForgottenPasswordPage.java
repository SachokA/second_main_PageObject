package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        inputEmailNew.sendKeys("awdasds@dfg.uo");
        return this;
    }

    public ForgottenPasswordPage buttonClickContinue() {
        buttonContinue.click();
        return this;
    }

    public String alertMessage() {
        waitUntilPresent(alert, 10);
        return alert.getText();
    }

}
