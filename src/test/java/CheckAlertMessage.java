import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
@Slf4j
public class CheckAlertMessage extends BaseTest{

    @Test
    public void checkAlertMessageOnPageForgottenPassword(){
        MainPage mainPage = new MainPage();
        String actualMessage = mainPage.clickButtonMyAccount()
                .clickButtonForgottenPassword()
                .fullInputEmail()
                .buttonClickContinue()
                .alertMessage();
        Assert.assertEquals(actualMessage, "Warning: The E-Mail Address was not found in our records!");
    }
}

