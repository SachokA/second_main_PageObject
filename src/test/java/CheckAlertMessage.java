import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

public class CheckAlertMessage extends BaseTest{

    @Test
    public void testOne(){
        MainPage mainPage = new MainPage();
        String actual = mainPage.clickButtonMyAccount()
                .clickButtonForgottenPasword()
                .fullInputEmail()
                .buttonClickContinue()
                .alertMessage();
        Assert.assertEquals(actual, "Warning: The E-Mail Address was not found in our records!");
    }
}

