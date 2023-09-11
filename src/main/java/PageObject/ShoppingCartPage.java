package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {
    public SelenideElement

            authorizationButton = $(".autorization-btn"),
            authorizationEmailInPut = $(byName("email")),
            authorizationPasswordInPut = $(byName("password"), 0),
            submitInPUT = $(byValue("შესვლა")),
            allProductsPage = $(byLinkText("პროდუქცია")),
            authorSearch = $("#authorsearch"),
            addToCartOne = $(byAttribute("onclick", "addToCart(257)")),
            closeAddBookPopUp = $(".close"),
            addToCartTwo = $(byAttribute("data-book-id", "1370")),
            GoToShoppingCart = $(".fa-shopping-cart");

    public ElementsCollection BooksPrice = $$(".price");
    public ElementsCollection deleteItems = $$(".delete-item");

}
