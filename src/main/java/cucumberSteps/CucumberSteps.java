package cucumberSteps;

import ui.constants.IConstants;
import ui.pages.RegistrationPage;
import ui.steps.BaseSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

@Log4j2
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
        log.info("Registration page is opened");
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
        log.info("Creating of the account...");
    }

    @Then("Message about confirmation via email should appear an another page")
    public void messageAboutConfirmationViaEmailShouldAppearAnAnotherPage() {
        softAssert.assertTrue(baseSteps.isPageLoaded(REGISTRATION_CONFIRM_PAGE_URL));
        softAssert.assertTrue(registrationPage.getConfirmationMessage().contains("Waiting for email confirmation from"));
        softAssert.assertAll();
        log.info("Registration is correct!");
        driver.quit();
    }
}