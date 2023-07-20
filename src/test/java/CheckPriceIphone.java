import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import page.IphonePage;
import page.MainPage;

public class CheckPriceIphone extends BaseTest {
    @Test
    public void checkPriceIphone() {
        MainPage mainPage = new MainPage();
        IphonePage iphonePage = new IphonePage();
        mainPage.checkCurrencyIsDollar()
                .clickIphone();
        String actualResultPriceDollar = iphonePage
                .getPriceIphoneDollar();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualResultPriceDollar).as("Not the same").isEqualTo("120.20");

        iphonePage.changedCurrencyEuro();
        String actualResultPriceEuro = iphonePage
                .getPriceIphoneEuro();
        softAssertions.assertThat(actualResultPriceEuro).as("Not the same").isEqualTo("11.45");

        iphonePage.changedCurrencyPound();
        String actualResultPricePound = iphonePage
                .getPriceIphoneDPound();
        softAssertions.assertThat(actualResultPricePound).as("Not the same").isEqualTo("96.41");

        softAssertions.assertAll();
    }
}
