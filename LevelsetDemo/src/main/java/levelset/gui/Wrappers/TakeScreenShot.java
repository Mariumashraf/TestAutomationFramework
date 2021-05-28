package levelset.gui.Wrappers;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static levelset.gui.actions.BrowserActions.driver;


public class TakeScreenShot {


	// Method to take screenshot when the test cases fail
	@Attachment(value = "Screenshot", type = "image/png")
	public static byte[] captureScreenshot(String screenshotname)
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	/*@Attachment(value = "Video on Failure", type = "video/mp4")
	public void getVideo(WebDriver driver ) throws ATUTestRecorderException {
		 atuTestRecorder = new ATUTestRecorder("C:\\Users\\lenovo\\Downloads\\LevelsetDemo\\videos","Test",false);
		atuTestRecorder.start();
	}
	@Attachment(value = "Video on Failure", type = "video/mp4")
	public void stopre(WebDriver driver ) throws ATUTestRecorderException {
		atuTestRecorder.stop();
	}*/
	/*public static byte[] is2ByeteArray(InputStream is) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while (true) {
			try {
				if (!((rc = is.read(buff, 0, 100)) > 0)) break;
			} catch (IOException e) {
				e.printStackTrace();
			}
			baos.write(buff, 0, rc);
		}

		return baos.toByteArray();
	}*/
	/*@Attachment(value = "record screen", type = "video/mp4")
	public byte[] attachRecord(WebDriver driver, String mp4) {

		System.out.println("mp4 -->" + mp4);
		Path content = Paths.get(mp4);
		InputStream is = null;
		try {
			is = Files.newInputStream(content);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return is2ByeteArray(is);
	}*/

}
