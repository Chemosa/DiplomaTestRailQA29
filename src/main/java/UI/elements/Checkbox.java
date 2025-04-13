package UI.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
    WebDriver driver;

    public Checkbox(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method select specified checkbox found by xpath.
     * @param dataTestIdOfCheckbox
     */
    public void selectCheckbox(String dataTestIdOfCheckbox) {
        driver.findElement(By.xpath(String.format("//*[@data-testid = \"%s\"]", dataTestIdOfCheckbox))).click();
    }

    /**
     * This method select specified checkbox as element.
     * @param checkbox
     */
    public void selectElementCheckbox(WebElement checkbox) {
        checkbox.click();
    }
}
