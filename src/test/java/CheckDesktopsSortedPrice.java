import org.testng.Assert;
import org.testng.annotations.Test;
import page.DesktopsPage;
import page.MainPage;

import java.util.List;

public class CheckDesktopsSortedPrice extends BaseTest {

    @Test
    public void checkSortedName() {
        MainPage mainPage = new MainPage();
        DesktopsPage desktopsPage = new DesktopsPage();
        mainPage.clickButtonShowAllDesktop()
                .selectCountShow("10");
        List<String> actualList = desktopsPage
                .getProducts();
        List<String> expectedList = desktopsPage
                .getProductsSort();
        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void checkSortedPriceLowHigh() {
        DesktopsPage desktopsPage = new DesktopsPage();
        desktopsPage
                .selectSortedPrice("Price (Low > High)");
        List<Double> actualListPrice = desktopsPage
                .getProductsPrice();
        List<Double> expectedListPrice = desktopsPage
                .getProductsSortPrice();
        Assert.assertEquals(actualListPrice, expectedListPrice);
    }
}
