package UI.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    private static final String INPUT_XPATH = "//*[@data-testid=\"%s\"]";

    WebDriver driver;
    String dataTestIdOfInput;

    public Input(WebDriver driver, String dataTestIdOfInput) {
        this.driver = driver;
        this.dataTestIdOfInput = dataTestIdOfInput;
    }

    /**
     * This method write text to specified input found by xpath.
     * @param textToWrite
     * @return
     */
    public Input writeTextToInput(String textToWrite) {
        driver.findElement(By.xpath(String.format(INPUT_XPATH, dataTestIdOfInput))).sendKeys(textToWrite);
        return this;
    }
}