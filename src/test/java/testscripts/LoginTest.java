package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;
import constant.Constant;
import pages.LoginPage;
import utiltiy.ExcelOperations;

public class LoginTest extends TestBase {

	@Test(dataProvider = "LoginDataProvider")
	public void verifyValidLogin(String userName, String password, boolean isLogin) {
		LoginPage loginPage = LoginPage.getObject();
		loginPage.clickOnSign();
		loginPage.enterUserNamePassword(userName, password);
		loginPage.clickOnLoginButton();
		String pageTitle = PredefinedActions.getPageTitle();
		if (isLogin) {
			Assert.assertTrue(pageTitle.contains("Home"));
		} else if (!isLogin) {
			Assert.assertTrue(loginPage.isLoginErrorMessageDisplays());
			System.out.println("Error message is: " + loginPage.getErrorMessageText());
		}
	}

	@Test(enabled = false)
	public void verifyInvalidLogin() {

		LoginPage loginPage = LoginPage.getObject();
		loginPage.clickOnSign();
		loginPage.enterUserNamePassword("testemail1@gmailds.com", "Passdword@1");
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.isLoginErrorMessageDisplays());
		System.out.println("Error message is: " + loginPage.getErrorMessageText());
	}

	@DataProvider(name = "LoginDataProvider")
	public Object[][] getLoginData() throws IOException {

		Object[][] data = ExcelOperations.readExcelData(Constant.EXCELFILEPATH, "Login");

		return data;

	}

}
