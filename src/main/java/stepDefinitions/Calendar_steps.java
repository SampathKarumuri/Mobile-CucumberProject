package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.Calendar.Calendar_Home;
import org.testng.Assert;

public class Calendar_steps {

    Calendar_Home calendar_home;
    TestContext testContext;

    public Calendar_steps(TestContext context) {

        testContext = context;
        calendar_home = testContext.getPageObjectManager().getCalendar_home();
    }

    @Given("I have launched the Calendar App")
    public void i_have_launched_the_calendar_app() {

        Assert.assertTrue(calendar_home.isAddEventDisplayed(),"Calendar App is not launched");
    }

}
