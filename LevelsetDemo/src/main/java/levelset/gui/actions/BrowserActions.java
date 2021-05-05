package levelset.gui.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.PhantomJsDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

import java.net.URL;

public class BrowserActions {

    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Initialize Browser")
    public WebDriver initializeWebDriver(@Optional("chrome")String browserName) {
        try {
            if (browserName.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase("Internet Explore")) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }else if (browserName.equalsIgnoreCase("Headless")) {
                WebDriverManager.phantomjs().setup();
                driver = new PhantomJSDriver();
            }else if(browserName.equalsIgnoreCase("ChromeDocker"))
            {
                driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            }
            else if(browserName.equalsIgnoreCase("FirefoxDocker")){
                driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
            }
        } catch (Exception e) {
            System.out.println("Failed to open Driver");


        }
        return driver;
    }


    @Step("Close Browser")
    public void closeDriver() {
        driver.quit();
    }

    @Step("Maximize Browser")
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }
}
