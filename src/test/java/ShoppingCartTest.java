import StepObject.ShoppingCartPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DataObject.ShoppingCartPageData.*;
import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartTest extends ChromeRunner {
    ShoppingCartPageSteps addToCartPageSteps = new ShoppingCartPageSteps();

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
                .AddToCartTwo()
                .ClosePopUp()
                .GoToShoppingCartPage()
                .CheckSum()
                .DeleteItems();
    }

    @Test
    @Description(" ქეისი 2- კალათაში არსებული პროდუქტების ფასის ჯამის მიხედვით საკურიერო მომსახურების ფასის განსაზღვრა")
    @Severity(SeverityLevel.CRITICAL)
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
                .AddToCartTwo()
                .ClosePopUp()
                .GoToShoppingCartPage()
                .CheckSum()
                .CheckcourierservicePrice()
                .DeleteItems();
    }
}
