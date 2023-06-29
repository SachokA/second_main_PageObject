import org.testng.Assert;
import org.testng.annotations.Test;
import page.DesktopsPage;
import page.MainPage;

public class checkDekstopsAll extends BaseTest {
    @Test
    public void testOne() {
        MainPage mainPage = new MainPage();
        DesktopsPage desktopsPage = new DesktopsPage();
        String actualCountShow = mainPage.clickButtonShowAllDesktop()
                .getValueCountShow();
        Assert.assertEquals(actualCountShow, "10");
        String actualSortShow = mainPage.clickButtonShowAllDesktop()
                .getValueSortShow();
        Assert.assertEquals(actualSortShow, "Default");
        int actualCountProducts = desktopsPage
                .countFindAll();
        Assert.assertEquals(actualCountProducts, 10);
        String actualGetText = desktopsPage.selectCountShow("25")
                .getValueCheckTest();
        Assert.assertEquals(actualGetText, "Showing 1 to 12 of 12 (1 Pages)");

    }
}
