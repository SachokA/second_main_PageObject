package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CamerasPage extends BasePage {

    public CamerasPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='price-old']")
    private WebElement camerasOldPriseCanon;

    @FindBy(xpath = "//span[@class='price-new']")
    private WebElement camerasNewPriseCanon;

    @FindBy(xpath = "//span[@class='price-tax']")
    private WebElement camerasPriceTax;

    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<WebElement> productsAllCamera;

    public List<String> getCameras() {
        List<String> list = new ArrayList<>();
        List<WebElement> all = productsAllCamera;

        for (WebElement element : all) {
            list.add(element.getText());
        }
        return list;
    }

    public String cannonOldPrice() {
        String oldPrice = camerasOldPriseCanon.getText().replace("$","");
        return oldPrice;
    }

    public String cannonNewPrice() {
        String newPrice = camerasNewPriseCanon.getText().replace("$","");
        return newPrice;
    }
    public String cannonPriceTax() {
        String taxPrice = camerasPriceTax.getText().replace("$","").substring(8);
        return taxPrice;
    }
}
