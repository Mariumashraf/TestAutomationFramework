package desktop.pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class NotepadPage {

    WindowsDriver driver = null;

    public NotepadPage(WindowsDriver driver){
        this.driver = driver;

    }

    public WebElement minimize(){
        return driver.findElementByName("Minimize");
    }
    public WebElement maximize(){
        return driver.findElementByName("Maximize");
    }
    public WebElement close(){
        return driver.findElementByName("Close");
    }

    public WebElement menuFile(){
        return driver.findElementByName("File");
    }
    public WebElement textArea(){
        return driver.findElementByClassName("Edit");
    }
    public WebElement save(){
        return driver.findElementByName("Save");
    }
    public WebElement dontSave(){
        return driver.findElementByName("Don't Save");
    }
    public WebElement cancel(){
        return driver.findElementByName("Cancel");
    }

}
