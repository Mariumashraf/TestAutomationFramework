package levelset.tests;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import levelset.Wrappers.Helper;
import levelset.Wrappers.TestAllureListener;
import levelset.actions.BrowserActions;
import levelset.pages.BasePage;
import levelset.pages.HomePage;
import levelset.pages.SelectDocumentPage;
import levelset.Wrappers.ExcelReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
    public void setup(String browserName) {
        browserActions = new BrowserActions(driver);
        driver = browserActions.initializeWebDriver(browserName);
        browserActions.maximizeBrowser();
        System.out.println(driver);
        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
        selectDocumentPage = new SelectDocumentPage(driver);
        newHelper = new Helper(driver);

    }

    @BeforeMethod
    public void openHomePage() {
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
        System.out.println(selectDocumentPage.getDocumentNameFromCard(documentName));
        Assert.assertEquals(selectDocumentPage.getDocumentNameFromLabel(), documentName);
    }

    @AfterMethod
    @Step("Take Image")
    public void takePhoto(ITestResult result) throws MalformedURLException {

        newHelper.captureScreenshot(driver,result.getName());
        newHelper.getVideo(new URL("http://localhost:8080/download_video/%s.mp4"));
    }
  /*  @AfterMethod
    public void takeScreenShot(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }else if (result.getStatus() == ITestResult.SUCCESS)
        {
            System.out.println("Passed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }else if (result.getStatus() == ITestResult.SKIP)
        {
            System.out.println("Skipped!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }

    }*/

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
