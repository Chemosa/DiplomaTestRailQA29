package UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {

    private static final String TITLE_INFO_MESSAGE_XPATH = "//*[@class=\"empty-title\"]";
    private static final String PROJECT_NAME_XPATH = "//*[@data-testid=\"testCaseContentHeaderTitle\"]";

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method gets title text from informational message.
     * @return
     */
    public String getTitleFromInfoMessage() {
        return driver.findElement(By.xpath(TITLE_INFO_MESSAGE_XPATH)).getText();
    }

    /**
     * This method gets name of the project.
     * @return
     */
    public String getProjectName() {
        return driver.findElement(By.xpath(PROJECT_NAME_XPATH)).getText();
    }

    /**
     * This method checks is test chart is displayed.
     * @return
     */
    public boolean projectChartIsDisplayed() {
        return driver.findElement(By.id("chart-line-fc")).isDisplayed();
    }
}
