package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FirstLoginPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.ProductPage;
import pages.ProductSpecificationPage;
import pages.ReviewAndPaymentPage;
import pages.ShippingPage;

public class E2EOrderTest extends TestBase{
	
	@Test(enabled = true)
	public void verifyE2EOrder() throws InterruptedException {
		
		LoginPage loginPage = LoginPage.getObject();
		loginPage.clickOnSign();
		loginPage.enterUserNamePassword("testemail1@gmail.com", "Password@1");
		loginPage.clickOnLoginButton();
		
	    FirstLoginPage firstLoginPage = FirstLoginPage.getObject();
        firstLoginPage.hoverOnMenMenu();
        firstLoginPage.hoverToTopMenu();
        firstLoginPage.clickOnTees();
        
        ProductPage productPage = ProductPage.getObject();
        productPage.selectTees("Strike Endurance Tee");
        
        ProductSpecificationPage productSpecificationPage = ProductSpecificationPage.getObject();
        productSpecificationPage.selectColor();
        productSpecificationPage.selectSize("M");
        productSpecificationPage.clickOnAddToCart();
        String str= productSpecificationPage.getSuccessfulMessage();
        System.out.println(str);
        Assert.assertTrue(str.contains("You added "));
        productSpecificationPage.clickOnCart();
        productSpecificationPage.clickOnProceedToCheckout();

        ShippingPage shippingPage=ShippingPage.getObject();
        Thread.sleep(3000);
        shippingPage.clickOnNext();
        
        ReviewAndPaymentPage reviewAndPaymentPage = ReviewAndPaymentPage.getObject();
        Thread.sleep(5000);
        reviewAndPaymentPage.clickOnPlaceOrder();
        
        Thread.sleep(4000);
        OrderConfirmationPage orderConfirmationPage=OrderConfirmationPage.getObject();
        String confirmationText = orderConfirmationPage.getConfirmationText();
        Assert.assertEquals("Thank you for your purchase!", confirmationText);
        System.out.println(confirmationText);
	}

}
