package UI.elements;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input {

    private static final String INPUT_XPATH = "//*[@data-testid=\"%s\"]";

    WebDriver driver;

    public Input(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method write text to specified input found by xpath.
     * @param textToWrite
     * @return
     */
    public Input writeTextToInput(String dataTestIdOfInput, String textToWrite) {
        driver.findElement(By.xpath(String.format(INPUT_XPATH, dataTestIdOfInput))).sendKeys(textToWrite);
        return this;
    }

    /**
     * This method delete text from specified input found by xpath.
     * @param dataTestIdOfInput
     * @return
     */
    public Input deleteTextFromInput(String dataTestIdOfInput) {
        driver.findElement(By.xpath(String.format(INPUT_XPATH, dataTestIdOfInput))).clear();
        return this;
    }

    /**
     * This method write text to specified as element input.
     * @param input
     * @param text
     * @return
     */
    public Input writeTextToInput(WebElement input, String text) {
        input.sendKeys(text);
        return this;
    }

    /**
     * This method write text to input specified by ID.
     * @param id
     * @param text
     * @return
     */
    public Input writeTextToInputById(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
        return this;
    }

    /**
     * This method write letters slowly one by one to specified input.
     * @param dataTestIdOfInput
     * @param text
     * @return
     */
    @SneakyThrows
    public Input slowTypeToInput(String dataTestIdOfInput, String text) {
        for (char letter : text.toCharArray()) {
            driver.findElement(By.xpath(String.format(INPUT_XPATH, dataTestIdOfInput))).sendKeys(Character.toString(letter));
            Thread.sleep(100);
        }
        return this;
    }
}