package levelset.Wrappers;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Helper {
	WebDriver driver;
	private UrlFetcher urlFetcher;
	public Helper(WebDriver driver){
		this.driver = driver;
	}

	// Method to take screenshot when the test cases fail
	@Attachment(value = "Screenshot", type = "image/png")
	public static byte[] captureScreenshot(WebDriver driver , String screenshotname)
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "Video on Failure", type = "video/mp4")
	public byte[] getVideo(URL videoCaptureURL) {
		urlFetcher = new UrlFetcher();
		try {
			return urlFetcher.fetchWithRetry(videoCaptureURL, 4);
		} catch (TimeoutException | java.util.concurrent.TimeoutException e) {
			//logger.error("Failed fetching URL {}.", videoCaptureURL);
			return null;
		}
	}
}
