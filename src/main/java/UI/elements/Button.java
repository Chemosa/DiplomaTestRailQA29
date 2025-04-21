package UI.elements;

import UI.waiters.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {

    private static final String BUTTON_XPATH = "//*[@data-testid=\"%s\"]";

    WebDriver driver;
    Waiter waiter = new Waiter();

    public Button(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method clicks on specified button found by dataTestId.
     */
    public void clickButton(String dataTestId) {
        driver.findElement(By.xpath(String.format(BUTTON_XPATH, dataTestId))).click();
    }

    /**
     * This method waits till element will be clickable and clicks on specified as web element button.
     * @param element
     */
    public void clickElementButton(WebElement element) {
        waiter.waitForWebElementBeClickable(driver, element, 10);
        element.click();
    }
}