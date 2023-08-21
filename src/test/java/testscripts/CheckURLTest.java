package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class CheckURLTest extends TestBase {
	
	@Test
	public void verifyURL() {

		String actualPageTitle= PredefinedActions.getPageTitle();
		String expectedPageTitle = "Home Page";
        Assert.assertTrue(actualPageTitle.contains(expectedPageTitle),"Actual Page Title is " + actualPageTitle );
	}
}
