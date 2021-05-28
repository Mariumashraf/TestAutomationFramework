package levelset.gui.actions;

import levelset.gui.Wrappers.Log;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import static levelset.gui.actions.BrowserActions.driver;

/*
Control Window Manager
Back, Forward, Refresh
Switch to new tab
 */

public class WindowManager {

    private WebDriver.Navigation navigate;

    public WindowManager(){
        navigate = driver.navigate();
    }

    public void goBack(){
        Log.info("Go Back");
        navigate.back();
    }

    public void goForward(){
        Log.info("Forward");
        navigate.forward();
    }

    public void refreshPage(){
        Log.info("Refresh Page");
        navigate.refresh();
    }

    public void switchToNewTab(int tabIndex){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));

    }
}
