package UI.elements;

import UI.waiters.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    private static final String CHECKBOX_XPATH = "//*[@data-testid=\"%s\"]";

    WebDriver driver;
    Waiter waiter = new Waiter();

    public Checkbox(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method select specified checkbox found by xpath.
     * @param dataTestIdOfCheckbox
     * @param selected
     */
    public void selectCheckbox(String dataTestIdOfCheckbox, boolean selected) {
        WebElement checkbox = driver.findElement(By.xpath(String.format(CHECKBOX_XPATH, dataTestIdOfCheckbox)));
        waiter.waitForWebElementBeClickable(driver, checkbox, 10);
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * This method select specified checkbox as element.
     * @param checkbox
     * @param selected
     */
    public void selectElementCheckbox(WebElement checkbox, boolean selected) {
        waiter.waitForWebElementBeClickable(driver, checkbox, 10);
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * This method select specified checkbox found by id.
     * @param id
     * @param selected
     */
    public void selectCheckboxById(String id, boolean selected) {
        WebElement checkbox = driver.findElement(By.id(id));
        waiter.waitForWebElementBeClickable(driver, checkbox, 10);
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }
}