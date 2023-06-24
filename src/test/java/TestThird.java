import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.DesktopsPage;
import page.MainPage;

import java.util.List;

public class TestThird extends BaseTest{

    @Test
    public void testThird(){
        MainPage mainPage = new MainPage();
        DesktopsPage desktopsPage = new DesktopsPage();
        mainPage.clickButtonShowAllDesktop()
                .select("10");
        List<String> actualList = desktopsPage.getProducts();
        List<String> expectedList = desktopsPage.getProductsSort();

        Assert.assertEquals(actualList,expectedList);
        mainPage.clickButtonShowAllDesktop()
                .selectSorted("Price (Low > High)");
        List<Double> actualListPrice = desktopsPage.getProductsPrice();
        List<Double> expectedListPrice = desktopsPage.getProductsSortPrice();
               Assert.assertEquals(actualListPrice,expectedListPrice);
    }

//    @Test
//    public void testThriftSortPrice () {
//        MainPage mainPage = new MainPage();
//        DesktopsPage desktopsPage = new DesktopsPage();
//        mainPage.clickButtonShowAllDesktop().selectSorted("Price (Low > High)");
//        List<Double> actualListPrice = desktopsPage.getProductsPrice();
//        List<Double> expectedListPrice = desktopsPage.getProductsSortPrice();
//        SoftAssertions softAssertions = new SoftAssertions();
//        softAssertions.assertThat(actualListPrice).as("not sorted").isEqualTo(expectedListPrice);
//
//    }

}
