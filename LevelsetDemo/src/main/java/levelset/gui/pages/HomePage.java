package levelset.gui.pages;

import io.qameta.allure.Step;
import levelset.gui.actions.UIActions;
import org.openqa.selenium.By;


public class HomePage {

    UIActions uiActions;
    //   BasePage basePage = new BasePage(driver); ;

    // private By createDocumentSelectror_btn = By.xpath("//li[@class='top-level-link ml-sm-05 mr-sm-05 relative']");
  /*  By createDocumentSelectror_btn = By.xpath("//li[@class='top-level-link ml-sm-05 mr-sm-05 relative']");
    By sendDocumentSelector_Btn = By.xpath("//label[text()='Send a Document']");*/
    By createDocumentSelectror_btn = By.xpath("//header/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[7]/a[1]");
    By sendDocumentSelector_Btn = By.xpath("//label[text()='Send a Document']");

    @Step("Click on Creat a Document Button")
    public void clickOnCreateDocumentLink() {
        uiActions = new UIActions();
        uiActions.clickOn(createDocumentSelectror_btn, sendDocumentSelector_Btn);
    }


}
