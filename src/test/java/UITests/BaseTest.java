package UITests;

import UI.constants.IConstants;
import UI.steps.BaseSteps;
import UI.steps.LoginSteps;
import UITests.constants.ITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstants, IConstants {
    WebDriver driver;
    BaseSteps baseSteps;
    LoginSteps loginSteps;
    SoftAssert softAssert;

    String EMAIL = PropertyReader.getProperty("email");
    String PASSWORD = PropertyReader.getProperty("password");
    String ACCESS_USER_URL = PropertyReader.getProperty("accessAddress");

    @BeforeMethod
    public void initTest(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        iTestContext.setAttribute("driver", driver);
        softAssert = new SoftAssert();
        PageFactory.initElements(driver, this);

        initPages();
    }

    public void initPages() {
        baseSteps = new BaseSteps(driver);
        loginSteps = new LoginSteps(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}
