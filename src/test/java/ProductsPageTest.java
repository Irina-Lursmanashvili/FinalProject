import StepObject.ProductsPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPageTest extends ChromeRunner {
    ProductsPageSteps productsPageSteps = new ProductsPageSteps();

    @Test
    public void sortingDesc() {
        productsPageSteps.GoToProducts()
                .SortPriceDesc()
                .CheckSort();

    }
    @Test
    public void discountCheck(){
        productsPageSteps.GoToProducts()
                .GoToBestSeller()
                .CheckDiscount();
    }
//ასერშენები მაქვს გასაწერი და სათაურები და ამბები. მე-16 ლექციის, როგორც რეგისტრაციის ტესტის ფეჯებზეა.

}


