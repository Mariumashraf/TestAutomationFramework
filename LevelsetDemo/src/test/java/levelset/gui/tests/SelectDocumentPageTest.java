package levelset.gui.tests;


import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import levelset.gui.Wrappers.Helper;
import levelset.gui.actions.BrowserActions;
import levelset.gui.pages.BasePage;
import levelset.gui.pages.SelectDocumentPage;
import levelset.gui.pages.HomePage;
import levelset.gui.Wrappers.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.net.MalformedURLException;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


public class SelectDocumentPageTest {
    WebDriver driver;
    BasePage basePage;
    HomePage homePage;
    SelectDocumentPage selectDocumentPage;
    BrowserActions browserActions;
    Helper newHelper;
    @BeforeSuite
    void setAllureEnvironment() {
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
        browserActions = new BrowserActions(driver);
        driver = browserActions.initializeWebDriver(browserName);
        browserActions.maximizeBrowser();

        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
        selectDocumentPage = new SelectDocumentPage(driver);
        newHelper = new Helper(driver);

    }

    @BeforeMethod
    public void openHomePage(){
        basePage.navigateToHomePage();
    }


    @Test(dataProvider = "nameOfDocuments", priority = 1, description = "Check Price")
    @Description("Check Price of each document")
    public void validatePrices(String documentName) {
        homePage.clickOnCreateDocumentLink();
        Assert.assertTrue(selectDocumentPage.getDocumentNameFromCard(documentName).contains("Free"));
    }


    @Test(dataProvider = "nameOfDocuments", priority = 2, description = "Ckeck label Text")
    @Description("Check label text after clicking on the card")
    public void validateLable(String documentName) {
        homePage.clickOnCreateDocumentLink();
        selectDocumentPage.clickOnDocumentCard(documentName);
        Assert.assertEquals(selectDocumentPage.getDocumentNameFromLabel(), documentName);
    }

    @AfterMethod
    @Step("Take Image")
    public void takePhoto(ITestResult result) throws MalformedURLException{
        newHelper.captureScreenshot(driver,result.getName());

    }

    @AfterClass
    public void tearDown() {
        browserActions.closeDriver();
    }

    @DataProvider
    public Object[][] nameOfDocuments() throws IOException {
        // get data from Excel Reader class
        ExcelReader helper = new ExcelReader();
        return helper.getExcelData("src/test/resources/TestData/NamesData.xlsx", 1);
    }

    @DataProvider(name="GetDocuments")
    public Object[] getDocuments(){
        return new Object[]
                {
                      "",
                      "",
                      "",
                      ""
                };
    }

}
