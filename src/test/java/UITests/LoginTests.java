package UITests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test(description = "Test that user can successfully login with correct email and password")
    public void successfulLoginTest() {
        loginSteps.login(EMAIL, PASSWORD, ACCESS_USER_URL + LOGIN_PAGE_URL);
        Assert.assertTrue(baseSteps.pageIsLoaded(ACCESS_USER_URL + PROJECTS_PAGE_URL));
    }

    @Test (description = "Test that user cannot login with incorrect email and password(more than 5 characters")
    public void unrealCredentialsLoginTest() {
        loginSteps.login("fakeEmail", "absentPassword", ACCESS_USER_URL + LOGIN_PAGE_URL);
        Assert.assertEquals(loginSteps.getErrorMessage(), ERROR_MESSAGE_LOGIN);
    }

    @Test (description = "Test that login is not performed if email and password fields are empty")
    public void emptyFieldsLoginTest() {
        loginSteps
                .login("", "", ACCESS_USER_URL + LOGIN_PAGE_URL)
                .checkErrorMessageUnderFieldIsDisplayed(EMPTY_EMAIL_ERROR, EMPTY_PASSWORD_ERROR);
    }
}
