package pages;

import base.PredefinedActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends PredefinedActions {

    private static OrderConfirmationPage orderConfirmationPage;

    @FindBy(xpath="//h1[@class='page-title']")
    WebElement confirmationText;

    private OrderConfirmationPage(){
    }

    public static OrderConfirmationPage getObject(){
        if(orderConfirmationPage==null)
            orderConfirmationPage= new OrderConfirmationPage();
        PageFactory.initElements(driver,orderConfirmationPage);
        return orderConfirmationPage;
    }

    public String getConfirmationText() throws InterruptedException {
        Thread.sleep(5000);
        return getElementText(confirmationText,true);
    }
    
}
