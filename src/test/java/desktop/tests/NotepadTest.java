package desktop.tests;

import desktop.pages.NotepadPage;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class NotepadTest {
    private WindowsDriver notepad = null;
    private NotepadPage notepadPage = null;

    @BeforeClass
    public void setup(){
        System.out.println("Setup");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app","notepad.exe");
        try {
            notepad = new WindowsDriver(new URL("http://127.0.0.1:4723"),desiredCapabilities);
            notepadPage = new NotepadPage(notepad);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    public void tearDown(){
        System.out.println("TearDown");
        notepad.quit();

    }

    @Test
    public void testNotePad(){
        System.out.println("Test");
        notepadPage.maximize();
        notepadPage.textArea().sendKeys("Hello");
        notepadPage.textArea().sendKeys(Keys.ENTER);
        notepadPage.textArea().sendKeys("My name is Marium");
        notepadPage.textArea().sendKeys(Keys.ENTER);
        notepadPage.textArea().sendKeys("I'm a Test Automation Engineer");
        notepadPage.textArea().sendKeys(Keys.ALT,Keys.F4);
        notepadPage.dontSave().click();

    }











    // Assert.assertEquals(notepadPage.textArea().getText(),"Hello\nMy name is Marium\nI'm a Test Automation Engineer");


}
