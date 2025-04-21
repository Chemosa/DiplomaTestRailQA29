package UI.steps;

import UI.pages.RegistrationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class RegistrationSteps extends BaseSteps {
    RegistrationPage registrationPage;

    public RegistrationSteps(WebDriver driver) {
        super(driver);
        this.registrationPage = new RegistrationPage(driver);
    }

    @Step("Try to registry user with empty data fields")
    public RegistrationSteps registrationWithEmptyFields() {
        registrationPage
                .openRegistrationPage(REGISTRATION_PAGE_URL)
                .clickCreateAccountButton();
        return this;
    }

    @Step("Get error message on registration page")
    public boolean isErrorMessageDisplayed(String error) {
        return registrationPage.isErrorMessagePresent(error);
    }
}
