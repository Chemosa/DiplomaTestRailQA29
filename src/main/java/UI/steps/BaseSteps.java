package UI.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that page {urlShouldBeOpened} is opened or not")
    public boolean pageIsLoaded(String urlShouldBeOpened) {
        return driver.getCurrentUrl().equals(urlShouldBeOpened);
    }
}
