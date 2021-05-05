package levelset.gui.pages;

import io.qameta.allure.Step;
import levelset.gui.Wrappers.PropertiesReader;
import levelset.gui.actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage {
    public WebDriver driver;
    UIActions uiActions;
    // BrowserActions browserActions = new BrowserActions(driver);

    String homePageURL = PropertiesReader.getProperty("URL");
    By requestCallSelector_btn = By.xpath("//a[contains(text(),'Request a Call')]");


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

   /* public WebDriver init() {
        browserActions = new BrowserActions(driver);
        driver = browserActions.initializeWebDriver("Chrome");
        browserActions.maximizeBrowser();
        uiActions = new UIActions(driver);
        return driver;
    }*/

    @Step("Navagiate to Levelset Home Page")
    public void navigateToHomePage() {
        uiActions = new UIActions(driver);
        uiActions.navigateToURL(homePageURL, requestCallSelector_btn);
    }
}
