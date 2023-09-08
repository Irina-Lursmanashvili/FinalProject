package StepObject;

import PageObject.ShoppingCartPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPageSteps extends ShoppingCartPage {

    @Step("ავტორიზაციის გვერდზე გადასვლა")
    public ShoppingCartPageSteps GoToAuthorizationPage() {
        authorizationButton.click();
        return this;
    }

    @Step("ელფოსტის ველის შევსება მნიშვნელობით: {Email}")
    public ShoppingCartPageSteps fillEmail(String Email) {
        authorizationEmailInPut.setValue(Email);
        return this;
    }

    @Step("პაროლის ველის შევსება მნიშვნელობით: {Password}")
    public ShoppingCartPageSteps fillPassword(String Password) {
        authorizationPasswordInPut.setValue(Password);
        return this;
    }

    @Step("ავტორიზაციის ღილაკზე ხელის დაჭერა")
    public ShoppingCartPageSteps clickLoginButton() {
        submitInPUT.click();
        return this;
    }

    @Step("პროდუქციის გვერდზე გადასვლა")
    public ShoppingCartPageSteps GoToProducts() {
        allProductsPage.click();
        return this;
    }

    @Step("სერჩის ველში ჩადგომა და ავტორის მოძებნა მნიშვნელობით: {AuthorName}")
    public ShoppingCartPageSteps AuthorSearch(String AuthorName) {
        authorSearch.setValue(AuthorName).pressEnter();
        return this;
    }

    @Step("პირველი წიგნის კალათაში დამატება")
    public ShoppingCartPageSteps AddToCartOne() {
        addToCartOne.click();
        return this;
    }

    @Step("\"წიგნი წარმატებით დაემატა\"პოპ აპის გამორთვა")
    public ShoppingCartPageSteps ClosePopUp() {
        closeAddBookPopUp.click();
        return this;
    }

    @Step(" მეორე წიგნის კალათაში დამატება")
    public ShoppingCartPageSteps AddToCartTwo() {
        addToCartTwo.click();
        return this;
    }

    @Step("კალათაში გადასვლა")
    public ShoppingCartPageSteps GoToShoppingCartPage() {
        GoToShoppingCart.click();
        return this;
    }

    @Step(" კალათაში დამატებული პროდუქტების ფასების ჯამის გაგება")
    public ShoppingCartPageSteps CheckSum() {

        String TotalPrice = $(".total_price").getText();
        String totalPrice = TotalPrice.replaceAll("₾", "");
        float Total_Price = Float.parseFloat(totalPrice);

        float sum = 0;

        for (int i = 0; i < BooksPrice.size(); i++) {

            String BookPrice = $(".price", i).getText();
            String Book_Price = BookPrice.replaceAll("₾", "");

            sum += Float.parseFloat(Book_Price);
        }

        /*if (sum == Total_Price) {
            System.out.println("ჯამი სწორია");
        } else {
            System.out.println("ჯამი არასწორია");
        }*/

        Assert.assertTrue(sum == Total_Price, "პროდუქტების ფასების ჯამის შემოწმება");

        return this;
    }

    @Step("საკურიერო მომსახურების საფასურის დათვლა")
    public ShoppingCartPageSteps CheckcourierservicePrice() {


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


        /*if (sum > 35) {
            if (Courier_Price != 0)
                System.out.println("საკურუერო მომსახურების საფასური არ განულდა");
            else System.out.println("საკურუერო მომსახურების საფასური განულდა");
        }*/

        Assert.assertTrue(sum > 35 && Courier_Price != 0, "საკურიერო მომსახურების საფასური სწორია");

        return this;
    }

    @Step("კალათაში არსებული პროდუქტების წაშლა")
    public ShoppingCartPageSteps DeleteItems() {


        for (int i = 0; i < deleteItems.size(); i++) {
            $(".delete-item", i).click();
        }
        return this;
    } //ლოგაუთი მაქვს დარჩენილი და უნდა გავაკეთო.......................

}










