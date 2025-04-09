package UITests.constants;

import utils.PropertyReader;

public interface ITestConstants {

   String EMAIL = PropertyReader.getProperty("email");
   String PASSWORD = PropertyReader.getProperty("password");
   String ACCESS_USER_URL = PropertyReader.getProperty("accessAddress");

   String ERROR_MESSAGE_LOGIN = "Sorry, there was a problem.\n" + "Email/Login or Password is incorrect. Please try again.";
   String EMPTY_EMAIL_ERROR = "Email/Login is required.";
   String EMPTY_PASSWORD_ERROR = "Password is required.";

}
