package pages;

import base.PredefinedActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewAndPaymentPage extends PredefinedActions {

    private static ReviewAndPaymentPage reviewAndPaymentPage;
    @FindBy(xpath="//button[@class='action primary checkout']")
    WebElement placeOrder;

    ReviewAndPaymentPage(){

    }

    public static ReviewAndPaymentPage getObject(){
        if(reviewAndPaymentPage==null)
            reviewAndPaymentPage = new ReviewAndPaymentPage();
        PageFactory.initElements(driver, reviewAndPaymentPage);
        return  reviewAndPaymentPage;
    }

    public void clickOnPlaceOrder(){
        clickOnElement(placeOrder,true);
    }

}
