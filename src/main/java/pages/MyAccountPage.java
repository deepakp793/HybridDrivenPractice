package pages;

import base.PredefinedActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPage extends PredefinedActions {
	
	
	private static MyAccountPage myAccountPage;
    @FindBy(css="ul[class='nav items'] a")
    private List <WebElement> myAccountOptionsElement;



    private MyAccountPage(){

    }
    
    public static MyAccountPage getObject() {	
    	if(myAccountPage==null)
    		myAccountPage=new MyAccountPage();
        PageFactory.initElements(driver,myAccountPage);
    	return myAccountPage;
    }

    public List<String> getOptionList(){
        List<String> myAccountOpitons=getListOfElementText(myAccountOptionsElement);
        return myAccountOpitons;
    }


}
