package pages;

import base.PredefinedActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductSpecificationPage extends PredefinedActions {

    private static ProductSpecificationPage productSpecificationPage;
    @FindBy(xpath = "//div[@class='swatch-option text']")
    List <WebElement> listOfSize;

    @FindBy(xpath = "//div[@option-label='Black']")
    WebElement blackColorElement;

    @FindBy(css="button[title='Add to Cart']")
    WebElement addToCart;

    @FindBy(xpath="//div[contains(text(),'You added')]")
    WebElement confirmationMessage;

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cart;

    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    WebElement proceedCheckout;


    private ProductSpecificationPage(){

    }

    public static ProductSpecificationPage getObject(){
        if(productSpecificationPage==null)
            productSpecificationPage = new ProductSpecificationPage();
        PageFactory.initElements(driver, productSpecificationPage);
        return productSpecificationPage;
    }

    public void selectSize(String size){
        for(WebElement e : listOfSize){
            if(e.getText().equals(size)){
                clickOnElement(e, true);
                break;
            }
        }
    }

    public void selectColor(){
        clickOnElement(blackColorElement, true);
    }

    public void clickOnAddToCart(){
        clickOnElement(addToCart,false);
    }

    public String getSuccessfulMessage(){
        return getElementText(confirmationMessage,true);
    }

    public void clickOnCart(){
        clickOnElement(cart,true);
    }

    public void clickOnProceedToCheckout(){
        clickOnElement(proceedCheckout,true);
    }



}
