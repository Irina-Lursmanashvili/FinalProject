package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public SelenideElement

            authorizationButton = $(".autorization-btn"),
            nameInPut = $(byName("name")),
            surnameInPut = $(byName("surname")),
            birthDateInPut = $("#datepicker"),
            emailInPut = $(byName("registremail")),
            phoneNumberInPut = $(byName("phone")),
            passwordInput = $(byAttribute("placeholder", "პაროლი"), 1),
            confirmPasswordInput = $(byAttribute("placeholder", "პაროლის დადასტურება")),
            AgreeTermsInPut = $(byText("ვეთანხმები საიტის")),
            registrationButton = $(byValue("გაგზავნა")),
            ErrorMessagePassword=$(byText("პაროლები უნდა ემთხვეოდეს"));
}
