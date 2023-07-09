import org.testng.Assert;
import org.testng.annotations.Test;
import page.CamerasPage;
import page.MainPage;

public class CheckCameras extends BaseTest {

    @Test
    public void CheckCountCamerasOnPage() {
        MainPage mainPage = new MainPage();
        int actualResultCountCamerasOnPage = mainPage
                .clickButtonCameras()
                .getCameras()
                .size();
        Assert.assertEquals(actualResultCountCamerasOnPage, 2);
    }

    @Test
    public void checkOldPriceOnPageCameras() {
        CamerasPage camerasPage = new CamerasPage();
        String actualResulOldPriceCannon = camerasPage
                .cannonOldPrice();
        Assert.assertEquals(actualResulOldPriceCannon, "122.00");
    }

    @Test
    public void checkNewPriceOnPageCameras() {
        CamerasPage camerasPage = new CamerasPage();
        String actualResulNewPriceCannon = camerasPage
                .cannonNewPrice();
        Assert.assertEquals(actualResulNewPriceCannon, "98.00");
    }

    @Test
    public void checkTaxCannonOnPageCameras() {
        CamerasPage camerasPage = new CamerasPage();
        String actualResulTaxCannon = camerasPage
                .cannonPriceTax();
        Assert.assertEquals(actualResulTaxCannon, "80.00");
    }
}
