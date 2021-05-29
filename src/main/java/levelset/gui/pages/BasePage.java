package levelset.gui.pages;

import io.qameta.allure.Step;
import levelset.gui.Wrappers.PropertiesReader;
import levelset.gui.actions.UIActions;
import org.openqa.selenium.By;

public class BasePage {

    UIActions uiActions= new UIActions();;

    String homePageURL = PropertiesReader.getProperty("URL");
    By requestCallSelector_btn = By.xpath("//a[contains(text(),'Request a Call')]");


    @Step("Navagiate to Levelset Home Page")
    public void navigateToHomePage() {
        uiActions.navigateToURL(homePageURL, requestCallSelector_btn);
    }
}
