package mobile.config;

import levelset.gui.Wrappers.PropertiesReader;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileConfigruations {

    public static AndroidDriver<WebElement> driver;

    public static void  initialization() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", PropertiesReader.getProperty("deviceName"));

        caps.setCapability("platformVersion", PropertiesReader.getProperty("platformVersion"));
        caps.setCapability("platformName", PropertiesReader.getProperty("platformName"));
        caps.setCapability("automationName", PropertiesReader.getProperty("automationName"));
        caps.setCapability("bundleId", PropertiesReader.getProperty("AppPackage"));
        caps.setCapability("AppPackage", PropertiesReader.getProperty("AppPackage"));
        caps.setCapability("appWaitPackage", PropertiesReader.getProperty("AppPackage"));

        caps.setCapability("AppActivity", PropertiesReader.getProperty("AppActivity"));
        caps.setCapability("appWaitActivity", PropertiesReader.getProperty("AppActivity"));
        caps.setCapability("appWaitDuration", 100000);

        caps.setCapability("noReset", true);
        caps.setCapability("fullReset", false);

        File file = new File("Apps/camelan.apk");
        caps.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

    }

}
