package levelset.gui.tests;


import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import levelset.gui.Wrappers.Log;
import levelset.gui.Wrappers.PropertiesReader;
import levelset.gui.Wrappers.TakeScreenShot;
import levelset.gui.actions.BrowserActions;
import levelset.gui.pages.BasePage;
import levelset.gui.pages.SelectDocumentPage;
import levelset.gui.pages.HomePage;
import levelset.gui.Wrappers.ExcelReader;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static levelset.gui.actions.BrowserActions.driver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


public class SelectDocumentPageTest {

    BasePage basePage;
    HomePage homePage;
    SelectDocumentPage selectDocumentPage;
    BrowserActions browserActions;
    TakeScreenShot takeScreenShot;


    @BeforeSuite
    void setAllureEnvironment() {
        DOMConfigurator.configure("log4j.xml");
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Tester", "Marium Ashraf")
                        .put("WebSite", "Levelset")
                        .put("URL", "https://www.levelset.com/")
                        .build());
    }

    @BeforeClass
    @Parameters("browserName")
    public void setup(String browserName) throws MalformedURLException {
        browserActions = new BrowserActions();
        browserActions.initializeWebDriver(browserName);
        browserActions.maximizeBrowser();

        homePage = new HomePage();
        basePage = new BasePage();
        selectDocumentPage = new SelectDocumentPage();
        takeScreenShot = new TakeScreenShot();

    }

    @BeforeMethod
    public void openHomePage() {

        basePage.navigateToHomePage();
    }


    @Test(dataProvider = "nameOfDocuments", priority = 1, description = "Check Price")
    @Description("Check Price of each document")
    public void validatePrices(String documentName,Method method) {
        Log.startTestCase(method.getName());
        homePage.clickOnCreateDocumentLink();
        Assert.assertTrue(selectDocumentPage.getDocumentNameFromCard(documentName).contains("Free"));
        Log.endTestCase();
    }


    @Test(dataProvider = "nameOfDocuments", priority = 2, description = "Ckeck label Text")
    @Description("Check label text after clicking on the card")
    public void validateLable(String documentName, Method method) {
        Log.startTestCase(method.getName());
        homePage.clickOnCreateDocumentLink();
        selectDocumentPage.clickOnDocumentCard(documentName);
        Assert.assertEquals(selectDocumentPage.getDocumentNameFromLabel(), documentName);
        Log.endTestCase();
    }

    @AfterMethod
    @Step("Take Image")
    public void takePhoto(ITestResult result,Method method) {
        takeScreenShot.captureScreenshot(result.getName());
    }

    @AfterClass
    public void tearDown() {
        browserActions.closeDriver();
    }

    @DataProvider
    public Object[][] nameOfDocuments() throws IOException {
        // get data from Excel Reader class
        ExcelReader helper = new ExcelReader();
        return helper.getExcelData(PropertiesReader.getProperty("PathExcel"), 1);
    }

    @DataProvider(name = "GetDocuments")
    public Object[] getDocuments() {
        return new Object[]
                {
                        "",
                        "",
                        "",
                        ""
                };
    }

}
