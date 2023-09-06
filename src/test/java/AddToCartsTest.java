import StepObject.AddToCartPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static DataObject.AddToCartPageData.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class AddToCartsTest extends ChromeRunner {
    AddToCartPageSteps addToCartPageSteps = new AddToCartPageSteps();

    @Test
    @Description("ქეისი 1- კალათაში არსებული პროდუქტების ფასის ჯამის შემოწმება")
    @Severity(SeverityLevel.CRITICAL)
    public void SumCheck() {
        addToCartPageSteps.GoToAuthorizationPage()
                .fillEmail(authorizationEmail)
                .fillPassword(authorizationPassword)
                .clickLoginButton()
                .GoToProducts()
                .AuthorSearch(authorSearchOne)
                .AddToCartOne()
                .ClosePopUp()
                .AuthorSearch(authorSearchTwo)
                .ClosePopUp()
                .GoToShoppingCartPage()
                .CheckSum()
                .DeleteItems();
    }

    @Test
    @Description(" ქეისი 2- კალათაში არსებული პროდუქტების ფასის ჯამის მიხედვით საკურიერო მომსახურების ფასის განსაზღვრა")
    @Severity(SeverityLevel.NORMAL)
    public void CourierservicePrice() {
        addToCartPageSteps.GoToAuthorizationPage()
                .fillEmail(authorizationEmail)
                .fillPassword(authorizationPassword)
                .clickLoginButton()
                .GoToProducts()
                .AuthorSearch(authorSearchOne)
                .AddToCartOne()
                .ClosePopUp()
                .AuthorSearch(authorSearchTwo)
                .ClosePopUp()
                .GoToShoppingCartPage()
                .CheckSum()
                .CheckcourierservicePrice()
                .DeleteItems();

    }

   //................... ასერშენებია გასაწერი.
}
