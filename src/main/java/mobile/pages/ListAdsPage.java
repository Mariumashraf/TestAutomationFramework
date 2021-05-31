package mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import static mobile.config.MobileConfigruations.driver;


public class ListAdsPage{

	public SearchPage clickOnSearch() throws IOException {
		driver.findElement(By.id("com.camelan:id/mainSearchTextView")).click();
		return new SearchPage();
	}

	public DogsPage clickOnDogsCategory() throws IOException {
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/androidx.cardview.widget.CardView/android.widget.ImageView"))
				.click();
		return new DogsPage();

	}

}
