package StepObject;

import PageObject.RegistrationPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationPageSteps extends RegistrationPage {
    @Step("რეგისტრაციის გვერდზე გადასვლა")
    public RegistrationPageSteps GoToRegistrationPage() {
        authorizationButton.click();
        return this;
    }

    @Step("სახელის ველის შევსება მნიშვნელობით: {Name}")
    public RegistrationPageSteps fillName(String Name) {
        nameInPut.setValue(Name);
        return this;
    }

    @Step("გვარის ველის შევსება მნიშვნელობით: {lastName}")
    public RegistrationPageSteps fillSurname(String lastName) {
        surnameInPut.setValue(lastName);
        return this;
    }

    @Step("დაბადების თარიღის არჩევა მნიშვნელობით: {BirthDate}")
    public RegistrationPageSteps fillBirthDate(String BirthDate) {
        birthDateInPut.setValue(BirthDate);
        return this;

    }

    @Step("ელ.ფოსტის ველის შევსება მნიშვნელობით: {Email}")
    public RegistrationPageSteps fillEmail(String Email) {
        emailInPut.setValue(Email);
        return this;
    }

    @Step("ტელეფონის ნომრის ველის შევსება მნიშვნელობით: {PhoneNumber}")
    public RegistrationPageSteps fillPhoneNumber(String PhoneNumber) {
        phoneNumberInPut.setValue(PhoneNumber);
        return this;
    }

    @Step("პაროლის ველის შევსება მნიშვნელობით: {Password}")
    public RegistrationPageSteps fillPassword(String Password) {
        passwordInput.setValue(Password);
        return this;
    }

    @Step("პაროლის დადასტურება მნიშვნელობით: {ConfirmPassword}")
    public RegistrationPageSteps fillConfirmPassword(String ConfirmPassword) {
        confirmPasswordInput.setValue(ConfirmPassword);
        return this;
    }

    @Step("პაროლის დადასტურება მნიშვნელობით: {WrongConfirmPassword}")
    public RegistrationPageSteps fillWrongConfirmPassword(String WrongConfirmPassword) {
        confirmPasswordInput.setValue(WrongConfirmPassword);
        return this;
    }

    @Step("ვეთანხმები წესებსა და პირობებს")
    public RegistrationPageSteps fillAgreeTerms() {
        AgreeTermsInPut.pressEnter();
        return this;
    }

    @Step("რეგისტრაციის ღილაკზე დაჭერა")
    public RegistrationPageSteps ClickRegistrationButton() {
        registrationButton.click();
        return this;
    }


}
