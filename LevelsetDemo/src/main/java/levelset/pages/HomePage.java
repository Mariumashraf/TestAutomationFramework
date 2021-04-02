package levelset.pages;

import io.qameta.allure.Step;
import levelset.actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    UIActions uiActions;
    //   BasePage basePage = new BasePage(driver); ;

    // private By createDocumentSelectror_btn = By.xpath("//li[@class='top-level-link ml-sm-05 mr-sm-05 relative']");
    By createDocumentSelectror_btn = By.xpath("//li[@class='top-level-link ml-sm-05 mr-sm-05 relative']");
    By sendDocumentSelector_Btn = By.xpath("//label[text()='Send a Document']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Click on Creat a Document Button")
    public void clickOnCreateDocumentLink() {
        uiActions = new UIActions(driver);
        uiActions.clickOn(createDocumentSelectror_btn, sendDocumentSelector_Btn);
    }


}
