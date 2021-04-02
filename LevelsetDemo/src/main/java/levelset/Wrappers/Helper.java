package levelset.Wrappers;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Helper {
	WebDriver driver;
	public Helper(WebDriver driver){
		this.driver = driver;
	}

	// Method to take screenshot when the test cases fail
	@Attachment(value = "Screenshot", type = "image/png")
	public static byte[] captureScreenshot(WebDriver driver , String screenshotname)
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
