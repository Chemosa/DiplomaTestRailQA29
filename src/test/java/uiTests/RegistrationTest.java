package uiTests;

import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @Test(description = "Test that correct messages appear if to register with empty fields.")
    public void registrationWithEmptyFields() {
        registrationSteps
                .registrationWithEmptyFields();
        softAssert.assertTrue(registrationSteps.isErrorMessageDisplayed(EMPTY_FIRST_NAME_REGISTRATION_ERROR));
        softAssert.assertTrue(registrationSteps.isErrorMessageDisplayed(EMPTY_LAST_NAME_REGISTRATION_ERROR));
        softAssert.assertTrue(registrationSteps.isErrorMessageDisplayed(EMPTY_EMAIL_REGISTRATION_ERROR));
        softAssert.assertTrue(registrationSteps.isErrorMessageDisplayed(EMPTY_COMPANY_REGISTRATION_ERROR));
        softAssert.assertTrue(registrationSteps.isErrorMessageDisplayed(EMPTY_EXPECTED_USERS_REGISTRATION_ERROR));
        softAssert.assertTrue(registrationSteps.isErrorMessageDisplayed(EMPTY_COUNTRY_REGISTRATION_ERROR));
        softAssert.assertTrue(registrationSteps.isErrorMessageDisplayed(NOT_SELECTED_POLICY_REGISTRATION_ERROR));
    }
}
