import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import page.CamerasPage;
import page.MainPage;
import page.ProductComponentCameras;
import java.util.List;

public class ProductsTestCameras extends BaseTest {
    @Test
    public void Test() {
        MainPage mainPage = new MainPage();
        CamerasPage camerasPage = new CamerasPage();
        String expectedName = "Canon EOS 5D";
        String expectedPrice = "98.00";
        String expectedTax = "80.00";
        mainPage.clickButtonCameras();
        List<ProductComponentCameras> products = camerasPage
                .getAllProductsFromCamerasPage();
        ProductComponentCameras productToCheck = null;

        for (ProductComponentCameras product : products) {
            if (product.getName().contains(expectedName)) {
                productToCheck = product;
                break;
            }
        }
        Assertions.assertThat(productToCheck.getCurrentPrice())
                .as("Product price should be $22.00")
                .isEqualTo(expectedPrice);
        Assertions.assertThat(productToCheck.getExTaxPrice())
                .as("Product Ex tax should be $80.00")
                .isEqualTo(expectedTax);
    }
}
