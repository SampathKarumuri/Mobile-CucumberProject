package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverManager
{

    private AppiumDriver<MobileElement> driver;
    private final DesiredCapabilities capabilities = new DesiredCapabilities();
    String platformName;

    public DriverManager()
    {
        platformName = FileReaderManager.getInstance().getConfigReader().getPlatformName();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,FileReaderManager.getInstance().getConfigReader().getAutomationName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,FileReaderManager.getInstance().getConfigReader().getDeviceName());
        capabilities.setCapability(MobileCapabilityType.UDID, FileReaderManager.getInstance().getConfigReader().getUDID());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, FileReaderManager.getInstance().getConfigReader().getAppPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, FileReaderManager.getInstance().getConfigReader().getAppActivity());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 30);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

    }

    public AppiumDriver<MobileElement> getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }

    public AppiumDriver createDriver()
    {
        try
        {

            String port = "4723";
            URL serverAddress = new URL("http://localhost:" + port + "/wd/hub");
            if (platformName.toLowerCase().equals("android"))
                driver = new AndroidDriver(serverAddress , capabilities);
            else if (platformName.toLowerCase().equals("ios"))
                driver = new IOSDriver(serverAddress , capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

    public void closeDriver()
    {
        driver.closeApp();
        driver.quit();

    }
}
