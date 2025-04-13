package UI.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    WebDriver driver;

    public Button(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method clicks on specified button found by dataTestId.
     */
    public void clickButton(String dataTestId) {
        driver.findElement(By.xpath(String.format("//*[@data-testid=\"%s\"]", dataTestId))).click();
    }

    /**
     * This method clicks on specified as web element button.
     * @param element
     */
    public void clickElementButton(WebElement element) {
        element.click();
    }
}
