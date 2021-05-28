package levelset.gui.pages;

import io.qameta.allure.Step;
import levelset.gui.actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SelectDocumentPage {

    UIActions uiActions = new UIActions();;

    private By documentCard_btn(String nameOfDocument) {
        return By.xpath("//div[contains(text() , '" + nameOfDocument + "')]/..//span");
    }

    private By nameOfDocument_label = By.xpath("//div[@class='title']");




    @Step("Click on Document card")
    public void clickOnDocumentCard(String name) {

        uiActions.clickOn(documentCard_btn(name), nameOfDocument_label);
    }

    @Step("Get Document Name from the card")
    public String getDocumentNameFromCard(String name) {

        return uiActions.getText(documentCard_btn(name));
    }

    @Step("Get Document Name from the label")
    public String getDocumentNameFromLabel() {

        return uiActions.getText(nameOfDocument_label);
    }

}
