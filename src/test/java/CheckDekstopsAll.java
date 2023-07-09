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
        DesktopsPage desktopsPage = new DesktopsPage();
        String actualSortShow = desktopsPage
                .getValueSortShow();
        Assert.assertEquals(actualSortShow, "Default");
    }

    @Test
    public void countElementOnDesktopsPageShouldHaveTen() {
        DesktopsPage desktopsPage = new DesktopsPage();
        int actualCountProducts = desktopsPage
                .countFindAll();
        Assert.assertEquals(actualCountProducts, 10);
    }

    @Test
    public void selectCountShowTwentyFiveCheckMessage() {
        DesktopsPage desktopsPage = new DesktopsPage();
        String actualGetText = desktopsPage
                .selectCountShow("25")
                .getValueCheckTest();
        Assert.assertEquals(actualGetText, "Showing 1 to 12 of 12 (1 Pages)");
    }
}
