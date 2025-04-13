package UI.steps;

import UI.constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BaseSteps implements IConstants {
    WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that page {urlShouldBeOpened} is opened or not")
    public boolean pageIsLoaded(String urlShouldBeOpened) {
        return driver.getCurrentUrl().equals(urlShouldBeOpened);
    }

    @Step("Check if specified page is opened")
    public boolean openedPage(String openedUrl) {
        return driver.getCurrentUrl().contains(openedUrl);
    }
}
