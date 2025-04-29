package UI.steps;

import UI.constants.IConstants;
import UI.pages.RegistrationPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class CucumberSteps implements IConstants {
    WebDriver driver;
    BaseSteps baseSteps;
    RegistrationPage registrationPage;
    SoftAssert softAssert;

    @Before
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
        baseSteps = new BaseSteps(driver);
        softAssert = new SoftAssert();
    }

    @Given("User wants to get trial version of access to testrail.com")
    public void userWantsToGetTrialVersionOfAccessToTestrailCom() {
        registrationPage
                .openRegistrationPage(REGISTRATION_PAGE_URL);
    }

    @When("User fill the registration form")
    public void userFillTheRegistrationForm() {
        registrationPage
                .fillRegistrationPage("Armenia", "10");
    }

    @And("Click submission button to create account")
    public void clickSubmissionButtonToCreateAccount() {
        registrationPage
                .clickCreateAccountButton();
    }

    @Then("Message about confirmation via email should appear an another page")
    public void messageAboutConfirmationViaEmailShouldAppearAnAnotherPage() {
        softAssert.assertTrue(baseSteps.isPageLoaded(REGISTRATION_CONFIRM_PAGE_URL));
        softAssert.assertTrue(registrationPage.getConfirmationMessage().contains("Waiting for email confirmation from"));
        softAssert.assertAll();
    }
}