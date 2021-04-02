package levelset.actions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UIActions {

    private WebDriver driver;
    private Select select ;
    private JavascriptExecutor jse ;
    public Actions action ;

    public UIActions(WebDriver driver) {
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }


    @Step("Navigate to URL")
    public void navigateToURL(String URL, By element) {
        driver.get(URL);
        Assert.assertTrue(validateElement(ExpectedConditions.presenceOfElementLocated(element)));
    }

    @Step("Click on Element")
    public void clickOn(By element, By expectedElement) {
        Assert.assertTrue(validateElement(ExpectedConditions.visibilityOfElementLocated(element)));
        driver.findElement(element).click();
        //unique element
        Assert.assertTrue(validateElement(ExpectedConditions.presenceOfElementLocated(expectedElement)));
    }
    @Step("Set Text")
    public void setText(By element,String text) {
        validateElement(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).sendKeys(text);
    }

    @Step("Get Text")
    public String getText(By element) {
        try {
            validateElement(ExpectedConditions.presenceOfElementLocated(element));
            return driver.findElement(element).getText();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
            //screen shot
            //error from log
            //alternative solution
            //ملهاش لزمة
        }
    }

    @Step("Clear Text")
    public void clearText(By element)
    {
        validateElement(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).clear();
    }

    @Step("Select item from list")
    public void selectItem(By selectElement) {
        validateElement(ExpectedConditions.presenceOfElementLocated(selectElement));
        select = new Select(driver.findElement(selectElement));
    }

    @Step("Select item from list by Value")
    public void selectItemByValue(By selectElement, String value) {
        selectItem(selectElement);
        select.selectByValue(value);
        /*validateElement(ExpectedConditions.presenceOfElementLocated(selectElement));
        select = new Select(driver.findElement(selectElement));*/
    }

    @Step("Upload image using robot class")
    public void uploadImage(By uploadPhoto,String imagePath) throws AWTException {
        validateElement(ExpectedConditions.presenceOfElementLocated(uploadPhoto));
        driver.findElement(uploadPhoto).click();
        Robot robot = new Robot();
        StringSelection selection = new StringSelection(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Step("ScrollDown")
    public void scrollToBottom()

    {
        jse.executeScript("scrollBy(0,2500)");
    }

    @Step("ScrollDown until view element")
    public void scrollUntilViewElement(By myElement) {
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(myElement));
    }

    @Step("Hover to element")
    public void hoverElement(By element){
        action.moveToElement(driver.findElement(element)).perform();
    }





    @Step("Validate Element")
    public boolean validateElement(ExpectedCondition<WebElement> condition) {
        try {
            new WebDriverWait(driver, 60).until(condition);
            return true;

        } catch (Exception e) {
            return false;
        }
    }





    /*public boolean validateElement(By element, String conditionType){
        ExpectedCondition<WebElement> condition = null;
        switch (conditionType){
            case "presence":
                condition = ExpectedConditions.presenceOfElementLocated(element);
                break;
            case "clickable":
                condition = ExpectedConditions.elementToBeClickable(element);
                break;
            case"visibilty":
                condition = ExpectedConditions.visibilityOfElementLocated(element);
                break;


        }

        try{
            return true;

        }catch (Exception e){
            return false;

        }
    }*/


}
