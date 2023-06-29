import org.testng.Assert;
import org.testng.annotations.Test;
import page.DesktopsPage;
import page.MainPage;

import java.util.List;

public class checkDesktopsSortedPrice extends BaseTest {

    @Test
    public void testThird() {
        MainPage mainPage = new MainPage();
        DesktopsPage desktopsPage = new DesktopsPage();
        mainPage.clickButtonShowAllDesktop()
                .selectCountShow("10");
        List<String> actualList = desktopsPage
                .getProducts();
        List<String> expectedList = desktopsPage
                .getProductsSort();
        Assert.assertEquals(actualList, expectedList);
        mainPage.clickButtonShowAllDesktop()
                .selectSortedPrice("Price (Low > High)");
        List<Double> actualListPrice = desktopsPage
                .getProductsPrice();
        List<Double> expectedListPrice = desktopsPage
                .getProductsSortPrice();
        Assert.assertEquals(actualListPrice, expectedListPrice);
    }
}
