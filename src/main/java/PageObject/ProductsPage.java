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
            sortPriceDesc = $(byLinkText("ფასის კლების მიხედვით"));
    public ElementsCollection productsPrice = $$(".price");


}





