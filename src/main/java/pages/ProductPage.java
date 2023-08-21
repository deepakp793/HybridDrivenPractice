package pages;

import base.PredefinedActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends PredefinedActions {

    private static ProductPage productPage;
    @FindBy(xpath="//a[@class='product-item-link']")
    List<WebElement> listOfTees;

    private ProductPage(){

    }

    public static ProductPage getObject(){
        if(productPage==null)
            productPage=new ProductPage();
        PageFactory.initElements(driver,productPage);
        return productPage;
    }

    public void selectTees(String teeName){
        for(WebElement e : listOfTees){
            if(e.getText().equals(teeName)) {
                clickOnElement(e, true);
                break;
            }
        }
    }
}
