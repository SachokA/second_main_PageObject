package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(linkText = "Forgotten Password")
    private  WebElement forgottenPasswordLink;
    public LoginPage(){PageFactory.initElements(getDriver(),this);}
    public ForgottenPasswordPage clickButtonForgottenPasword(){
        forgottenPasswordLink.click();
        return new ForgottenPasswordPage();
    }
}
