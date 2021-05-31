package mobile.pages;

import org.openqa.selenium.By;
import static mobile.config.MobileConfigruations.driver;


public class SearchPage {

	public void searchAd() {
		driver.findElement(By.id("android:id/search_src_text")).sendKeys("cat");

	}

}
