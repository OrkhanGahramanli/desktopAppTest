import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

@org.testng.annotations.Test
public class WinAppTest {

    public void calcTest() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/");
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("ms:experimental-webdriver", true);
//        capabilities.setCapability("platformName", "Windows");
//        capabilities.setCapability("deviceName", "OrkhanG-IT");
//        capabilities.setCapability("automationName", "Windows");
        capabilities.setCapability("app",
                "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        WindowsDriver driver = new WindowsDriver(url, capabilities);
        driver.findElementByName("Five").click();
        driver.findElementByName("Multiply by").click();
        driver.findElementByName("Four").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals(driver.findElementByAccessibilityId("CalculatorResults").getText().split(" ")[2], "20");
    }

}
