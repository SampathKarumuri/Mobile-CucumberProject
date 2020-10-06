package managers;

import io.appium.java_client.AppiumDriver;
import pageObjects.Calendar.Calendar_Home;

public class PageObjectManager {

    private AppiumDriver driver;

    private Calendar_Home calendar_home;

    public PageObjectManager(AppiumDriver driver) {

        this.driver = driver;

    }

    public Calendar_Home getCalendar_home() {
        return (calendar_home == null) ? calendar_home = new Calendar_Home(driver) : calendar_home;
    }
}
