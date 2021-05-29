package levelset.gui.Wrappers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    int retryLimit = Integer.parseInt(PropertiesReader.getProperty("retryLimit"));
// IRetryAnalyzer interfacr of testNg
    @Override
    public boolean retry(ITestResult result) {
        if(counter < retryLimit){
            counter++;
            return true;
        }
        return false;

    }
}
