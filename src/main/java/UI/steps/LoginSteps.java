package UI.steps;

import UI.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps extends BaseSteps{

    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        super(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Step("Login by user: {email}")
    public LoginSteps login (String email, String password, String url) {
        loginPage
                .openLoginPage(url)
                .fillLoginFields(email, password);
        return this;
    }

    @Step("Get error message on login page")
    public String getErrorMessage() {
        return loginPage.getErrorMessage();
    }

    @Step("Check error message {errorMessage} under the field should be displayed")
    public LoginSteps checkErrorMessageUnderFieldIsDisplayed(String... errorMessage) {
        for (String errorText : errorMessage) {
            Assert.assertTrue(loginPage.checkErrorMessageUnderFieldsIsDisplayed(errorText));
        }
        return this;
    }
}
