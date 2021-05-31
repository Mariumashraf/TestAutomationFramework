package mobile.pages;

import org.openqa.selenium.By;
import static mobile.config.MobileConfigruations.driver;


public class DogsPage  {


	public void clickOnFirstAd() {
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout[1]/android.widget.ImageView[1]"))
				.click();
	}

}
