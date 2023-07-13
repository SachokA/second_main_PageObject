import org.testng.Assert;
import org.testng.annotations.Test;
import page.DesktopsPage;
import page.MainPage;

public class CheckDekstopsAll extends BaseTest {

    @Test
    public void checkValueCountShowTen() {
        MainPage mainPage = new MainPage();
        String actualCountShow = mainPage
                .clickButtonShowAllDesktop()
                .getValueCountShow();
        Assert.assertEquals(actualCountShow, "10");
    }

    @Test
    public void checkValueSortShowDefault() {
        MainPage mainPage = new MainPage();
        String actualSortShow = mainPage
                .clickButtonShowAllDesktop()
                .getValueSortShow();
        Assert.assertEquals(actualSortShow, "Default");
    }

    @Test
    public void countElementOnDesktopsPageShouldHaveTen() {
        MainPage mainPage = new MainPage();
        int actualCountProducts = mainPage
                .clickButtonShowAllDesktop()
                .countFindAll();
        Assert.assertEquals(actualCountProducts, 10);
    }

    @Test
    public void selectCountShowTwentyFiveCheckMessage() {
        MainPage mainPage = new MainPage();
        String actualGetText = mainPage
                .clickButtonShowAllDesktop()
                .selectCountShow("25")
                .getValueCheckTest();
        Assert.assertEquals(actualGetText, "Showing 1 to 12 of 12 (1 Pages)");
    }
}
