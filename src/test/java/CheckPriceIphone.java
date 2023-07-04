import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import page.IphonePage;
import page.MainPage;

//    Go to the https://demo.opencart.com/
//    On the main page check that current currency is $ (change to $ id not)
//    Click on the Iphone
//    Check that price 123.20
//    Change currency to euro
//    Chekk that price 106.04
//    Change currency to Pound Sterling
//    Check that price 95.32*/
public class CheckPriceIphone extends BaseTest {
    @Test
    public void testFourth() {
        MainPage mainPage = new MainPage();
        IphonePage iphonePage = new IphonePage();
        mainPage.checkCurrencyIsDollar()
                .clickIphone();
        String actualResultPriceDollar = iphonePage
                .getPriceIphoneDollar();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualResultPriceDollar).as("Not the same").isEqualTo("123.20");

        iphonePage.changedCurrencyEuro();
        String actualResultPriceEuro = iphonePage
                .getPriceIphoneEuro();
        softAssertions.assertThat(actualResultPriceEuro).as("Not the same").isEqualTo("113.38");

        iphonePage.changedCurrencyPound();
        String actualResultPricePound = iphonePage
                .getPriceIphoneDPound();
        softAssertions.assertThat(actualResultPricePound).as("Not the same").isEqualTo("97.31");

        softAssertions.assertAll();
    }
}
