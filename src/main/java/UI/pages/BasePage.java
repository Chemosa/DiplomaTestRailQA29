package UI.pages;

import UI.constants.IConstants;
import UI.waiters.Waiter;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage implements IConstants {
    WebDriver driver;
    Waiter waiter = new Waiter();
    Faker faker = new Faker();

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}