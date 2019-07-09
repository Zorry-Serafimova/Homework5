package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewUserInfoPage {
    @FindBy(linkText = "Update")
    private WebElement btnUpdate;
   /* @FindBy(xpath = "//th[contains(text(),'ID')]/following::td")
    private List<WebElement> tblValues;*/

    @FindBy(xpath = "//td[contains(text(),'57')]")
    private WebElement idCol;


    public ViewUserInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /*public List<WebElement> getTblValues() {
        return tblValues;
    }*/

    /*public void printtbl() {
        System.out.println("size: " + tblValues.size());
        for (WebElement el : tblValues) {
                System.out.println("values: " + el.getText());
            }
        }*/
    public void setIdCol(){
        System.out.println(idCol.getText());
    }

    public void clickOnUpdateButton(){
        btnUpdate.click();
    }

}
