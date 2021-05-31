package mobile.tests;

import mobile.pages.ListAdsPage;
import mobile.pages.SearchPage;
import static mobile.config.MobileConfigruations.driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static mobile.config.MobileConfigruations.initialization;

public class SearchPageTest  {
	ListAdsPage listAdsPage;
	SearchPage searchPage;

	@BeforeMethod
	public void setup(Method method) throws IOException {
		initialization();
		listAdsPage = new ListAdsPage();
	}

	@Test
	public void SearchAd(Method method) throws IOException {
		searchPage = listAdsPage.clickOnSearch();
		searchPage.searchAd();
	}

	@AfterMethod
	public void afterTest() throws InterruptedException, IOException {
		driver.quit();
	}

}
