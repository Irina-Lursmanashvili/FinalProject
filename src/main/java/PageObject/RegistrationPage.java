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
            passwordInput = $(byAttribute("placeholder", "პაროლი")),
            confirmPasswordInput = $(byName("password_confirmation")),
            AgreeTermsInPut = $(byText("ვეთანხმები საიტის")),
            registrationButton = $(byValue("გაგზავნა"));
}
