package page;


import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
@Getter
public class ProductComponentCameras {
    private WebElement image;
    private String name;
    private String currentPrice;
    private String oldPrice;
    private String exTaxPrice;
  //  private String reviews;

    public ProductComponentCameras() {
    }
    public ProductComponentCameras(WebElement container) {
        this.image = container.findElement(By.xpath(".//div[@class='image']"));
        this.name = container
                .findElement(By.xpath("//*[@id='product-list']")).getText();
        try {
            this.oldPrice = container.findElement(By.xpath(".//span[@class='price-old']"))
                    .getText().substring(1);
        } catch (NoSuchElementException e) {
            this.oldPrice = null;
        }
        this.currentPrice = container.findElement(By.xpath(".//span[@class='price-new']")).getText().substring(1);
        this.exTaxPrice = container.findElement(By.xpath(".//span[@class='price-tax']")).getText().substring(9);
//        try {
//            this.reviews = container.findElement(By.xpath(".//a[@class='action view']")).getText();
//        } catch (NoSuchElementException e) {
//            this.reviews = null;
//        }
    }
}


