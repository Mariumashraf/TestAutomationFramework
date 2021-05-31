package desktop.tests;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Calculator {
    private WindowsDriver calcSession = null;
    private WebElement calcResult = null;

    @BeforeClass
    public void setup(){
        System.out.println("setup");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app","Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        try {
            //Run on local machine "portNumber"
            calcSession = new WindowsDriver(new URL("http://127.0.0.1:4723"),desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    public void tearDown(){
        System.out.println("tearDown");
     //   calcSession.quit();
    }
    @BeforeMethod
    public void clear(){
        System.out.println("CLEAR");
        calcSession.findElementByName("Clear").click();
    }
    @Test
    public void addition(){
        System.out.println("addition");
        calcSession.findElementByName("One").click();
        calcSession.findElementByName("Two").click();
        calcSession.findElementByName("Plus").click();
        calcSession.findElementByName("Nine").click();
        calcSession.findElementByName("Equals").click();
        Assert.assertEquals(getDisplayResult(),"21");


    }
    @Test
    public void multiplication(){
        System.out.println("Multiplication");
        calcSession.findElementByName("Three").click();
        calcSession.findElementByName("Three").click();
        calcSession.findElementByName("Multiply by").click();
        calcSession.findElementByName("Three").click();
        calcSession.findElementByName("Equals").click();
        Assert.assertEquals(getDisplayResult(),"99");
    }

   @Test
    public void subtraction(){
        System.out.println("subtraction");
       calcSession.findElementByName("Three").click();
       calcSession.findElementByName("Three").click();
       calcSession.findElementByName("Minus").click();
       calcSession.findElementByName("Three").click();
       calcSession.findElementByName("Equals").click();
       Assert.assertEquals(getDisplayResult(),"30");

    }
    @Test
    public void division(){
        System.out.println("division");
        calcSession.findElementByName("Three").click();
        calcSession.findElementByName("Three").click();
        calcSession.findElementByName("Divide by").click();
        calcSession.findElementByName("Three").click();
        calcSession.findElementByName("Equals").click();
        Assert.assertEquals(getDisplayResult(),"11");

    }
    public String getDisplayResult(){
        calcResult = calcSession.findElementByAccessibilityId("CalculatorResults");
        return calcResult.getText().replace("Display is","").trim();

    }

    public void chooseCalculator(String locator){
        System.out.println(locator);
        calcSession.findElementByAccessibilityId("TogglePaneButton").click();
        List<WebElement> listOfElements = calcSession.findElementsByClassName("Microsoft.UI.Xaml.Controls.NavigationViewItem");
        System.out.println(listOfElements.size());
        for(int i = 0; i<listOfElements.size(); i++){
            if(listOfElements.get(i).getAttribute("Name").equals(locator)){
                listOfElements.get(i).click();
                break;
            }
        }
    }

    @Test
    public void selectAnotherCalcuator(){
        System.out.println("Selectiong another calculator");
        chooseCalculator("Scientific Calculator");

    }

    public void chooseCalculatorXpath(String locator){
        System.out.println(locator);
        calcSession.findElementByAccessibilityId("TogglePaneButton").click();
        //[@Name="Standard Calculator"][@AutomationId="Standard"]
        ///Pane[@ClassName="#32769"][@Name="Desktop 1"]/Window[@ClassName="ApplicationFrameWindow"][@Name="Calculator"]/Window[@ClassName="Windows.UI.Core.CoreWindow"][@Name="Calculator"]/Custom[@AutomationId="NavView"]/Window[@AutomationId="PaneRoot"]/Pane[@ClassName="ScrollViewer"]/Group[@AutomationId="MenuItemsHost"]
        List<WebElement> listOfElements = calcSession.findElementsByXPath("//ListItem");
        System.out.println(listOfElements.size());
        for(int i = 0; i<listOfElements.size(); i++){
            if(listOfElements.get(i).getAttribute("Name").equals(locator)){
                listOfElements.get(i).click();
                break;
            }
        }
    }

    @Test
    public void selectAnotherCalcuatorXpath(){
        System.out.println("Selectiong another calculator");
        chooseCalculatorXpath("Scientific Calculator");

    }



}
