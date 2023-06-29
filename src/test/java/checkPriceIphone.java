import org.testng.Assert;
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
public class checkPriceIphone extends BaseTest {
    @Test
    public void testFourth() {
        MainPage mainPage = new MainPage();
        IphonePage iphonePage = new IphonePage();
        mainPage.checkCurrencyIsDollar()
                .clickIphone();
        String actualResultPriceDollar = iphonePage
                .getPriceIphoneDollar();
        Assert.assertEquals(actualResultPriceDollar, "123.20");
        iphonePage.changedCurrencyEuro();
        String actualResultPriceEuro = iphonePage
                .getPriceIphoneEuro();
        Assert.assertEquals(actualResultPriceEuro, "106.04");
        iphonePage.changedCurrencyPound();
        String actualResultPricePound = iphonePage
                .getPriceIphoneDPound();
        Assert.assertEquals(actualResultPricePound, "95.32");
    }
}
