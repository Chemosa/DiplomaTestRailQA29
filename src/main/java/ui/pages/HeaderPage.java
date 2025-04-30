package ui.pages;

import ui.elements.Button;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method clicks on admin navigation button on header.
     * @return
     */
    public AdminPage clickNavigationAdminButton() {
        new Button(driver).clickButton("navigationUser");
        return new AdminPage(driver);
    }

    /**
     * This method clicks on TestRail logo on header.
     * @return
     */
    public ProjectsListPage clickLogo() {
        new Button(driver).clickButton("bannerLink");
        return new ProjectsListPage(driver);
    }
}
