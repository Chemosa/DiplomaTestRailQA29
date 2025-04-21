package UI.steps;

import UI.constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BaseSteps implements IConstants {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that page {urlShouldBeOpened} is opened or not")
    public boolean pageIsLoaded(String urlShouldBeOpened) {
        return driver.getCurrentUrl().contains(urlShouldBeOpened);
    }
}