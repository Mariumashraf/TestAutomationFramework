package mobile.tests;


import mobile.pages.DogsPage;
import mobile.pages.ListAdsPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import static mobile.config.MobileConfigruations.driver;


import static mobile.config.MobileConfigruations.initialization;

public class DogsPageTest {
	ListAdsPage listAdsPage;
	DogsPage dogsPage;



	@BeforeMethod
	public void setup(Method method) throws IOException {
		initialization();
		listAdsPage = new ListAdsPage();
	}

	@Test
	public void clickOnAd(Method method) throws IOException {
		dogsPage = listAdsPage.clickOnDogsCategory();
		dogsPage.clickOnFirstAd();
	}

	@AfterMethod
	public void afterTestt() throws InterruptedException, IOException {
		driver.quit();
	}

}
