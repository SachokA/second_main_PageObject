package page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class BrandsPage extends BasePage {
    @FindBy(xpath = "//div[@id='product-manufacturer']//div[@class='col-sm-3']/a")
    private List<WebElement> brandsLocatorAll;
    public BrandsPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public List<String> getBrands() {
        log.info("Getting list Brands");
        List<String> list = new ArrayList<>();
        List<WebElement> all = brandsLocatorAll;
        for (WebElement element : all) {
            list.add(element.getText());
        }
        return list;
    }
}
