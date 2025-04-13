package UI.waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    /**
     * This method waits till specified element will be displayed.
     * @param driver
     * @param elementDataTestId
     * @param seconds
     */
    public void waitForElementDisplayed(WebDriver driver, String elementDataTestId, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(By.xpath(String.format("//*[@data-testid = \"%s\"]", elementDataTestId)));
        wait.until(ExpectedConditions.visibilityOf(element));
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
     * @param element
     * @param seconds
     */
    public void waitForElementDisappearing(WebDriver driver, String element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
    }
}