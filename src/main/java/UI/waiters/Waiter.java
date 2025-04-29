package UI.waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    private static final String ELEMENT_TO_WAIT_XPATH = "//*[@data-testid = \"%s\"]";

    /**
     * This method waits till specified element will be displayed.
     * @param driver
     * @param elementDataTestId
     * @param seconds
     */
    public void waitForElementDisplayed(WebDriver driver, String elementDataTestId, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(By.xpath(String.format(ELEMENT_TO_WAIT_XPATH, elementDataTestId)));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method waits till specified web element will be displayed.
     * @param driver
     * @param element
     * @param seconds
     */
    public void waitForElementDisplayed(WebDriver driver, WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method waits till specified element will be displayed.
     * @param driver
     * @param xpath
     * @param seconds
     */
    public void waitForElementByXpathDisplayed(WebDriver driver, String xpath, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    /**
     * This method waits till specified webpage will be loaded.
     * @param driver
     * @param url
     * @param seconds
     */
    public void waitForPageOpened(WebDriver driver, String url, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.urlContains(url));
    }

    /**
     * This method waits till specified element will disappear.
     * @param driver
     * @param elementXpath
     * @param seconds
     */
    public void waitForElementDisappearing(WebDriver driver, String elementXpath, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));
    }

    /**
     * This method waits till specified element will be clickable.
     * @param driver
     * @param element
     * @param seconds
     */
    public void waitForWebElementBeClickable(WebDriver driver, WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}