package UI.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

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
    public Dropdown selectOption() {
        try{
            driver.findElement(By.id(label)).click();
            driver.findElement(By.xpath(String.format(DROPDOWN_OPTIONS_TEST_CASE_XPATH, option))).click();
        }catch (StaleElementReferenceException e) {
            driver.findElement(By.id(label)).click();
            driver.findElement(By.xpath(String.format(DROPDOWN_OPTIONS_TEST_CASE_XPATH, option))).click();
        }
        return this;
    }
}