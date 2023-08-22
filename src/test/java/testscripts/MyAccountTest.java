package testscripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import listener.RetryTestCases;
import pages.FirstLoginPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountTest extends TestBase {

	@Test(retryAnalyzer = RetryTestCases.class)
	public void verifyOptionsOnMyAccountPage() {

		LoginPage loginPage = LoginPage.getObject();
		loginPage.clickOnSign();
		loginPage.enterUserNamePassword("testemail1@gmail.com", "Password@1");
		loginPage.clickOnLoginButton();

		FirstLoginPage firstLoginPage = FirstLoginPage.getObject();
		firstLoginPage.clickOnDropDown();
		firstLoginPage.clickOnMyAccount();

		MyAccountPage myAccountPage = MyAccountPage.getObject();
		List<String> myAccountOptions = myAccountPage.getOptionList();
		String[] accOptinArr = { "My Orders", "My Downloadable Products", "My Wish List", "Address Book",
				"Account Information", "Stored Payment Methods", "My Product Reviews" };
		List<String> expectedOptionList = new ArrayList<String>(Arrays.asList(accOptinArr));
		System.out.println(myAccountOptions);
		System.out.println(expectedOptionList);
		Assert.assertTrue(myAccountOptions.equals(expectedOptionList));
	}
	
	@Test
	public void verifyOptionsOnHomePage() {
		LoginPage loginPage = LoginPage.getObject();
		loginPage.clickOnSign();
		loginPage.enterUserNamePassword("testemail1@gmail.com", "Password@1");
		loginPage.clickOnLoginButton();
		
		FirstLoginPage firstLoginPage = FirstLoginPage.getObject();
		String [] expMenuListArray = {"What's New", "Women", "Men","Gear", "Training", "Sale"};
		List <String> expectedMenuList = new ArrayList<String>(Arrays.asList(expMenuListArray));
		List <String> menuList = firstLoginPage.getMenuList();
		
		Assert.assertEquals(menuList, expectedMenuList, "Actual list not correct. Expected:"+expectedMenuList+"Actual:"+menuList);
		
	}

}
