package page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Slf4j
public class LoginPage extends BasePage{
    @FindBy(linkText = "Forgotten Password")
    private  WebElement forgottenPasswordLink;
    public LoginPage(){PageFactory.initElements(getDriver(),this);}
    public ForgottenPasswordPage clickButtonForgottenPassword(){
        log.info("Clicking button forgotten password");
        forgottenPasswordLink.click();
        return new ForgottenPasswordPage();
    }
}
