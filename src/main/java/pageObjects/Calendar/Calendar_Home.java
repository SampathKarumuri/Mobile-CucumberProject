package pageObjects.Calendar;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.util.List;

public class Calendar_Home {

    AppiumDriver<MobileElement> driver = null;
    public WebDriverWait wait;

    @AndroidFindBy(accessibility = "Add event")
    @iOSFindBy(xpath = "")
    private MobileElement addEvent;

    @AndroidFindBy(xpath = "//*[@resource-id='com.samsung.android.calendar:id/month_view_pager']//android.view.View")
    @iOSFindBy(xpath = "")
    private List<MobileElement> calendarFrameDay;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.samsung.android.calendar:id/title']")
    @iOSFindBy(xpath = "")
    private List<MobileElement> meetingsInCalendar;

    public Calendar_Home(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isAddEventDisplayed()
    {
        try {
            return addEvent.isDisplayed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    public void clickAddEvent()
    {
        addEvent.click();

    }

    public void selectDayFromCalendar(LocalDate date)
    {
        try
        {
            String dateFormat = String.valueOf(date.getYear()) + "-" + String.valueOf(date.getMonthValue()) + "-" + String.valueOf(date.getDayOfMonth());

            for (MobileElement day : calendarFrameDay)
            {
                if (day.getText().contains(dateFormat))
                {
                    day.click();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public boolean selectSavedMeeting(String title)
    {
        try
        {
            for (MobileElement meeting : meetingsInCalendar)
            {
                if (meeting.getText().startsWith(title))
                {
                    meeting.click();
                    System.out.println(meeting.getText() + " meeting is opened successfully");

                    return true;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;

    }

}
