package UI.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public Input writeCredentialsToLogin(String credential) {
        driver.findElement(By.id(label)).sendKeys(credential);
        return this;
    }
}
