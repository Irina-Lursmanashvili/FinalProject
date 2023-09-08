import StepObject.ProductsPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPageTest extends ChromeRunner {
    ProductsPageSteps productsPageSteps = new ProductsPageSteps();

    @Test
    @Description("ქეისი 1- გავიგოთ ფასის კლების მიხედვით სწორად დალაგდა თუ არა პროდუქცია")
    @Severity(SeverityLevel.NORMAL)
    public void sortingDesc() {
        productsPageSteps.GoToProducts()
                .SortPriceDesc()
                .CheckSort();

    }

    @Test
    @Description("ქეისი 2- ერთი პროდუქტის საფუძველზე გავიგოთ ფასდაკლება სწორად ანგარიშდება თუ არა")
    @Severity(SeverityLevel.NORMAL)
    public void discountCheck() {
        productsPageSteps.GoToProducts()
                .GoToBestSeller()
                .CheckDiscount();
    }

}


