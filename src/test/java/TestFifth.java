import org.testng.Assert;
import org.testng.annotations.Test;
import page.CamerasPage;
import page.MainPage;

/*Test #5

Go to the https://demo.opencart.com/
Click on the Cameras
Check that 2 cameras exist on page
Check that Canon EOS 5D has old price 122.00
Check that Canon EOS 5D has new price 98.00
Check that Nikon D300 has ex.rate 80.00*/
public class TestFifth extends BaseTest {

    @Test
    public void Test() {
        MainPage mainPage = new MainPage();
        CamerasPage camerasPage = new CamerasPage();
        int actualResultCountCamerasOnPage = mainPage
                .clickButtonCameras()
                .getCameras()
                .size();
        Assert.assertEquals(actualResultCountCamerasOnPage, 2);
        String actualResulOldPriceCannon = camerasPage
                .cannonOldPrice();
        Assert.assertEquals(actualResulOldPriceCannon, "122.00");
        String actualResulNewPriceCannon = camerasPage
                .cannonNewPrice();
        Assert.assertEquals(actualResulNewPriceCannon, "98.00");
        String actualResulTaxCannon = camerasPage
                .cannonPriceTax();
        Assert.assertEquals(actualResulTaxCannon, "80.00");
    }
}
