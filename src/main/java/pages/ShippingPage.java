package pages;

import base.PredefinedActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends PredefinedActions {

	private static ShippingPage shippingPage;
	@FindBy(xpath = "//button[@class='button action continue primary']")
	WebElement next;

	private ShippingPage() {

	}

	public static ShippingPage getObject() {
		if (shippingPage == null)
			shippingPage = new ShippingPage();
		PageFactory.initElements(driver, shippingPage);
		return shippingPage;
	}

	public void clickOnNext() {
		clickOnElement(next, true);
	}

}
