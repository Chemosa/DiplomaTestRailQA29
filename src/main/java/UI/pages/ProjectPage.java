package UI.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ProjectPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"empty-title\"]")
    WebElement titleInfoMessage;

    @FindBy(xpath = "//*[@data-testid=\"testCaseContentHeaderTitle\"]")
    WebElement projectNameInTitle;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method gets title text from informational message.
     * @return
     */
    public String getTitleFromInfoMessage() {
        try {
            log.info("Getting informational message.");
            return titleInfoMessage.getText();
        } catch (Exception noMessage) {
            log.error("Failed to get error message.", noMessage);
            return "";
        }
    }

    /**
     * This method gets name of the project.
     * @return
     */
    public String getProjectName() {
        try {
            log.info("Getting project name.");
            return projectNameInTitle.getText();
        } catch (Exception noName) {
            log.error("Failed to get error message.", noName);
            return "";
        }
    }

    /**
     * This method checks is test chart is displayed.
     * @return
     */
    public boolean projectChartIsDisplayed() {
        return driver.findElement(By.id("chart-line-fc")).isDisplayed();
    }
}