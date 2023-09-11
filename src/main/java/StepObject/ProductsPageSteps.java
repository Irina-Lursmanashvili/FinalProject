package StepObject;


import PageObject.ProductsPage;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPageSteps extends ProductsPage {
    @Step("პროდუქციის გვერდზე გადასვლა")
    public ProductsPageSteps GoToProducts() {
        allProductsPage.click();
        return this;
    }

    @Step("პროდუქციის ფასის კლების მიხედვით დალაგება")
    public ProductsPageSteps SortPriceDesc() {
        sortPriceDesc.click();
        return this;
    }

    @Step("პროდუქცია დალაგდა თუ არა სწორად ფასის კლების მიხედვით")
    public ProductsPageSteps CheckSort() {

        for (int i = 0; i < productsPrice.size() - 1; i++) {

            String FirstProduct = $(".price", i).$(byTagName("span"), 0).getText();
            String SecondProduct = $(".price", i + 1).$(byTagName("span"), 0).getText();

            FirstProduct = FirstProduct.replaceAll("₾ ", "");
            SecondProduct = SecondProduct.replaceAll("₾ ", "");

            float first_product = Float.parseFloat(FirstProduct);
            float second_product = Float.parseFloat(SecondProduct);

            Assert.assertTrue(first_product >= second_product,
                    "პროდუქციის ფასის კლების მიხედვით დალაგება");
        }
        return this;
    }

    @Step("ბესთსელერების გვერდზე გადასვლა")
    public ProductsPageSteps GoToBestSeller() {
        bestSellerPage.click();
        return this;
    }

    @Step("შემოწმება - სწორად აქვს თუ არა წიგნს ფასი დაკლებული")
    public ProductsPageSteps CheckDiscount() {

        String oldPrice = $(".old-price").getText();
        String old_Price = oldPrice.replaceAll("₾", "");
        float OldPrice = Float.parseFloat(old_Price);

        String percent = $(".sale").getText();
        String withoutPercentSymbol = percent.replaceAll("%", "");
        float Percent = Float.parseFloat(withoutPercentSymbol) * -1;

        String currentPrice = $(".price").$(byTagName("span"), 0).getText();
        String current_Price = currentPrice.replaceAll("₾", "");
        float CurrentPrice = Float.parseFloat(current_Price);

        Assert.assertTrue(Math.round((OldPrice - (OldPrice * Percent) / 100) * 100.0) / 100.0 == CurrentPrice,
                "ფასდაკლების შემოწმება");
        return this;
    }

}


