package UI.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    private static final String CHECKBOX_XPATH = "//*[@data-testid=\"%s\"]";

    WebDriver driver;

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
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if(!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * This method select specified checkbox as element.
     * @param checkbox
     * @param selected
     */
    public void selectElementCheckbox(WebElement checkbox, boolean selected) {
       if (selected && !checkbox.isSelected()) {
           checkbox.click();
       } else if(!selected && checkbox.isSelected()) {
           checkbox.click();
       }
    }
}
