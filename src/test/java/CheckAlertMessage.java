import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

public class CheckAlertMessage extends BaseTest{

    @Test
    public void checkAlertMessageOnPageForgottenPassword(){
        MainPage mainPage = new MainPage();
        String actualMessage = mainPage.clickButtonMyAccount()
                .clickButtonForgottenPasword()
                .fullInputEmail()
                .buttonClickContinue()
                .alertMessage();
        Assert.assertEquals(actualMessage, "  Warning: The E-Mail Address was not found in our records!");
    }
}

