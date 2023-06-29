import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import page.MainPage;

import java.util.Arrays;
import java.util.List;

public class CheckBrandsList extends BaseTest{

    @Test
    public void testZero(){
        MainPage mainPage = new MainPage();
        List<String> actualBrandsList = mainPage
                .clickLinkBrands()
                .getBrands();
        List<String>  expectedBrandsList= Arrays.asList("Apple","Canon","Hewlett-Packard","HTC","Palm","Sony");
        Assertions.assertThat(actualBrandsList).as("error name").containsExactlyElementsOf(expectedBrandsList);
    }
}
