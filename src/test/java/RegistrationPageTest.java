import StepObject.RegistrationPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DataObject.RegistrationPageData.*;

public class RegistrationPageTest extends ChromeRunner {
    RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

    @Test
    @Description("ქეისი 1- რეგისტრაციის გვერდზე მობილურის ნომრით ვალიდაცია")
    @Severity(SeverityLevel.BLOCKER)
    public void RegistrationCheck() {
        registrationPageSteps.GoToRegistrationPage()
                .fillPhoneNumber(phoneNumber);
        Assert.assertEquals(registrationPageSteps.phoneNumberInPut.getValue(), phoneNumber,
                "მობილური ნომრის ვალიდაცია");
    }

    @Test
    @Description("ქეისი 2- რეგისტრაციის შემოწმება არასწორი მონაცემით, პაროლი განმეორებით ჩავწეროთ არასწორად")
    @Severity(SeverityLevel.BLOCKER)
    public void RegistrationCheckNegativeCase() {
        registrationPageSteps.GoToRegistrationPage()
                .fillName(firstName)
                .fillSurname(surname)
                .fillBirthDate(birthDate)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(RegistrationPassword)
                .fillWrongConfirmPassword(wrongConfirmPassword)
                .fillAgreeTerms()
                .ClickRegistrationButton();
        Assert.assertTrue(registrationPageSteps.ErrorMessagePassword.is(Condition.visible),
                "პაროლის არასწორი მონაცემით დადასტურება");
    }
}
