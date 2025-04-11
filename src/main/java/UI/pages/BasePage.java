package UI.pages;

import UI.constants.IConstants;
import UI.waiters.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage implements IConstants {
    WebDriver driver;
    Waiter waiter = new Waiter();

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
