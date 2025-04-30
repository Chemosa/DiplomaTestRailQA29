package ui.elements;

import ui.waiters.Waiter;
import org.openqa.selenium.*;

public class Dropdown {

    private static final String DROPDOWN_OPTIONS_TEST_CASE_XPATH = "//li[text()='%s']";

    WebDriver driver;
    String label;
    String option;

    public Dropdown(WebDriver driver, String label, String option) {
        this.driver = driver;
        this.label = label;
        this.option = option;
    }

    /**
     * This method clicks on dropdown and selects specified option.
     * @return
     */
    public Dropdown selectOption(int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                Waiter waiter = new Waiter();
                WebElement dropdown = driver.findElement(By.id(label));
                waiter.waitForWebElementBeClickable(driver, dropdown, 10);
                dropdown.click();
                WebElement optionXpath = driver.findElement(By.xpath(String.format(DROPDOWN_OPTIONS_TEST_CASE_XPATH, option)));
                waiter.waitForWebElementBeClickable(driver, dropdown, 10);
                optionXpath.click();
                return this;
            } catch (StaleElementReferenceException | NoSuchElementException | TimeoutException e) {
                attempts++;
                if (attempts == maxAttempts) {
                    throw new RuntimeException(
                            String.format("Cannot select option '%s' from dropdown '%s' after %d attempts", option, label, maxAttempts), e);
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ignored) {

                }
            }
        }
        return this;
    }
}