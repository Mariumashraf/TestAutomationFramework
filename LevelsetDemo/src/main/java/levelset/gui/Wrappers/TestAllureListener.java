package levelset.gui.Wrappers;

import io.qameta.allure.Attachment;
import levelset.gui.actions.BrowserActions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static levelset.gui.actions.BrowserActions.driver;

public class TestAllureListener implements ITestListener {

    public static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Attachment(value = "Page screenshot",type = "image/png")
    public static byte[] captureScreenshot(WebDriver driver)
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Override
    public void onStart(ITestContext iTestContext){
        BrowserActions browserActions;
        browserActions = new BrowserActions();
        browserActions.initializeWebDriver("Chrome");
        iTestContext.setAttribute("WebDriver",driver);
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult){
        captureScreenshot(driver);
    }
    @Override
    public void onTestFailure(ITestResult iTestResult){
        captureScreenshot(driver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){
        captureScreenshot(driver);
    }
}
