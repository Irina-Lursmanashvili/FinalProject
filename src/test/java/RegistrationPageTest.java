import StepObject.RegistrationPageSteps;
import Utils.ChromeRunner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DataObject.RegistrationPageData.*;

public class RegistrationPageTest extends ChromeRunner {
    RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

    @Test
    @Description("რეგისტრაციის შემოწმება")
    @Severity(SeverityLevel.CRITICAL)
    public void RegistrationCheck() {
        registrationPageSteps.GoToRegistrationPage()
                .fillName(firstName)
                .fillSurname(surname)
                .fillBirthDate(birthDate)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillConfirmPassword(confirmPassword)
                .fillAgreeTerms()
                .ClickRegistrationButton();
        Assert.assertEquals(registrationPageSteps.phoneNumberInPut.getText(), phoneNumber);
    }

    @Test
    @Description("რეგისტრაციის შემოწმება")
    @Severity(SeverityLevel.CRITICAL)
    public void RegistrationCheckNegativeCase() {
        registrationPageSteps.GoToRegistrationPage()
                .fillName(firstName)
                .fillSurname(surname)
                .fillBirthDate(birthDate)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillConfirmPassword(wrongConfirmPassword)
                .fillAgreeTerms()
                .ClickRegistrationButton();
        Assert.assertEquals(registrationPageSteps.phoneNumberInPut.getText(), phoneNumber);
    }




}