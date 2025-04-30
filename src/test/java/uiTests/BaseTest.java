package uiTests;

import UI.constants.IConstants;
import UI.entities.Project;
import UI.steps.*;
import org.testng.annotations.AfterMethod;
import uiTests.constants.ITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstants, IConstants {
    WebDriver driver;
    BaseSteps baseSteps;
    LoginSteps loginSteps;
    ProjectsSteps projectsSteps;
    TestCasesSteps testCasesSteps;
    RegistrationSteps registrationSteps;
    TestRunsAndResultsSteps testRunsAndResultsSteps;
    SoftAssert softAssert;
    Project project;

//    public static String EMAIL = PropertyReader.getProperty("email");
//    public static String PASSWORD = PropertyReader.getProperty("password");
//    public static String ACCESS_USER_URL = PropertyReader.getProperty("accessAddress");
    public static String EMAIL = System.getProperty("email");
    public static String PASSWORD= System.getProperty("password");
    public static String ACCESS_USER_URL= System.getProperty("accessAddress");

    @BeforeMethod
    public void initTest(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        iTestContext.setAttribute("driver", driver);
        softAssert = new SoftAssert();
        PageFactory.initElements(driver, this);

        initPages();
    }

    public void initPages() {
        project = new Project();
        baseSteps = new BaseSteps(driver);
        loginSteps = new LoginSteps(driver);
        projectsSteps = new ProjectsSteps(driver);
        testCasesSteps = new TestCasesSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        testRunsAndResultsSteps = new TestRunsAndResultsSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void deleteProjectAfterTestAndQuit() {
        projectsSteps.deleteProjectAfterTest();
    }

    @AfterMethod
    public void quit() {
        softAssert.assertAll();
        driver.quit();
    }
}