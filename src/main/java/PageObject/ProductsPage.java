package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {


    public SelenideElement

            allProductsPage = $(byLinkText("პროდუქცია")),
            bestSellerPage = $(byLinkText("ბესტსელერი")),
            sortPriceDesc = $(byLinkText("ფასის კლების მიხედვით")),
            authorSearchInPut = $("#authorsearch"),
            firstProductPrice = $(".price").$(byTagName("span"), 0);
    public ElementsCollection productsPrice = $$(".price");
    public ElementsCollection bestSellersProductsPrice = $$(".price");
}





