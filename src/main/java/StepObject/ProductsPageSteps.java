package StepObject;


import PageObject.ProductsPage;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPageSteps extends ProductsPage {

    public ProductsPageSteps GoToProducts() {
        allProductsPage.click();
        return this;
    }

    public ProductsPageSteps SortPriceDesc() {
        sortPriceDesc.click();
        return this;
    }

    public ProductsPageSteps CheckSort() {


        String firstProduct = firstProductPrice.getText();
        System.out.println(firstProduct);

        for (int i = 0; i < productsPrice.size() - 1; i++) {

            String FirstProduct = $(".price", i).$(byTagName("span"), 0).getText();
            String SecondProduct = $(".price", i + 1).$(byTagName("span"), 0).getText();

            FirstProduct = FirstProduct.replaceAll("₾ ", "");
            SecondProduct = SecondProduct.replaceAll("₾ ", "");

            float first_product = Float.parseFloat(FirstProduct);
            float second_product = Float.parseFloat(SecondProduct);

            Assert.assertTrue(first_product >= second_product, "ფასის კლებადობის შემოწმება");
            System.out.println(FirstProduct);
        }
        return this;
    }

    public ProductsPageSteps GoToBestSeller() {
        bestSellerPage.click();
        return this;
    }

    public ProductsPageSteps CheckDiscount() {

        ElementsCollection bestSellersProductsPrice = $$(".price");

        String oldPrice = $(".old-price").getText();
        String old_Price = oldPrice.replaceAll("₾", "");
        float OldPrice = Float.parseFloat(old_Price);
        System.out.println(OldPrice);

        String percent = $(".sale").getText();
        String withoutPercentSymbol = percent.replaceAll("%", "");
        float Percent = Float.parseFloat(withoutPercentSymbol) * -1;
        System.out.println(Percent);

        String currentPrice = $(".price").$(byTagName("span"), 0).getText();
        String current_Price = currentPrice.replaceAll("₾", "");
        float CurrentPrice = Float.parseFloat(current_Price);
        System.out.println(CurrentPrice);


        if (OldPrice - Math.round((OldPrice * Percent) / 100 * 10.0) / 10.0 == CurrentPrice) {
            System.out.println("ფასდაკლება სწორია");
        } else System.out.println("ფასდაკლება არასწორია");
        return this;
    }


}


