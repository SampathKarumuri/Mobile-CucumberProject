package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import context.TestContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScenarioHooks
{
	TestContext testContext;

	public ScenarioHooks(TestContext context) {
		testContext = context;
	}
	@Before
    public void setup() { }

	@After
	public void tearDown(Scenario scenario)
	{
		// Take a screenshot, on failure
		if(scenario.isFailed()) {

			final byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);

			// embed it in the report.
			scenario.embed(screenshot, "image/png");
		}

		testContext.getWebDriverManager().closeDriver();

	}
}