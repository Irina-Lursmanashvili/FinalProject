package StepObject;

import DataObject.AddToCartPageData;
import PageObject.AddToCartPage;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class AddToCartPageSteps extends AddToCartPage {

    @Step("ავტორიზაციის გვერდზე გადასვლა")
    public AddToCartPageSteps GoToAuthorizationPage() {
        authorizationButton.click();
        return this;
    }

    @Step("ელფოსტის ველის შევსება მნიშვნელობით: {Email}")
    public AddToCartPageSteps fillEmail(String Email) {
        authorizationEmailInPut.setValue(Email);
        return this;
    }

    @Step("პაროლის ველის შევსება მნიშვნელობით: {Password}")
    public AddToCartPageSteps fillPassword(String Password) {
        authorizationPasswordInPut.setValue(Password);
        return this;
    }

    @Step("ავტორიზაციის ღილაკზე ხელის დაჭერა")
    public AddToCartPageSteps clickLoginButton() {
        authorizationButton.click();
        return this;
    }

    @Step("პროდუქციის გვერდზე გადასვლა")
    public AddToCartPageSteps GoToProducts() {
        allProductsPage.click();
        return this;
    }

    @Step("სერჩის ველში ჩადგომა და ავტორის მოძებნა მნიშვნელობით: {AuthorName}")
    public AddToCartPageSteps AuthorSearch(String AuthorName) {
        authorSearch.setValue(AuthorName).click();
        return this;
    }

    @Step("პირველი წიგნის კალათაში დამატება")
    public AddToCartPageSteps AddToCartOne() {
        addToCartOne.click();
        return this;
    }

    @Step("\"წიგნი წარმატებით დაემატა\"პოპ აპის გამორთვა")
    public AddToCartPageSteps ClosePopUp() {
        closeAddBookPopUp.click();
        return this;
    }

    @Step(" მეორე წიგნის კალათაში დამატება")
    public AddToCartPageSteps AddToCartTwo() {
        addToCartTwo.click();
        return this;
    }

    @Step("კალათაში გადასვლა")
    public AddToCartPageSteps GoToShoppingCartPage() {
        GoToShoppingCart.click();
        return this;
    }

    @Step(" გავიგოთ კალათაში დამატებული პროდუქტების ფასის ჯამი სწორია თუ არა")
    public AddToCartPageSteps CheckSum() {

        String TotalPrice = $(".total_price").getText();
        String totalPrice = TotalPrice.replaceAll("₾", "");
        float Total_Price = Float.parseFloat(totalPrice);

        float sum = 0;

        for (int i = 0; i < BooksPrice.size(); i++) {

            String BookPrice = $(".price", i).getText();
            String Book_Price = BookPrice.replaceAll("₾", "");

            sum += Float.parseFloat(Book_Price);
        }

        if (sum == Total_Price) {
            System.out.println("ჯამი სწორია");
        } else {
            System.out.println("ჯამი არასწორია");
        }

        return this;
    }

    @Step("საკურიერო მომსახურების საფასურის დათვლა")
    public AddToCartPageSteps CheckcourierservicePrice() {


        String TotalPrice = $(".total_price").getText();
        String totalPrice = TotalPrice.replaceAll("₾", "");
        float Total_Price = Float.parseFloat(totalPrice);

        float sum = 0;

        for (int i = 0; i < BooksPrice.size(); i++) {

            String BookPrice = $(".price", i).getText();
            String Book_Price = BookPrice.replaceAll("₾", "");

            sum += Float.parseFloat(Book_Price);
        }

        //.......................ეს ფორ ციკლი  ორივე ტესტქეისში მიწერია და ცალკე სტეპად ხო არ უნდა გავიტანო?........

        String courierPrice = $(".courierPrice").getText();
        String courier_Price = courierPrice.replaceAll("₾", "");
        float Courier_Price = Float.parseFloat(courier_Price);


        if (sum > 35) {
            if (Courier_Price != 0)
                System.out.println("საკურუერო მომსახურების საფასური არ განულდა");
            else System.out.println("საკურუერო მომსახურების საფასური განულდა");
        }

        return this;
    }

    @Step("კალათაში არსებული პროდუქტების წაშლა")
    public AddToCartPageSteps DeleteItems() {


        for (int i = 0; i < deleteItems.size(); i++) {
            $(".delete-item", i).click();
        }
        return this;
    } //ლოგაუთი მაქვს დარჩენილი და უნდა გავაკეთო.......................

}










