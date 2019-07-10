package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewUserInfoPage {
    @FindBy(linkText = "Update")
    private WebElement btnUpdate;
   /* @FindBy(css = "td")
    private List<WebElement> tblValues;

    @FindBy(id = "w0")
    private WebElement idCol;

@FindBy (xpath = "//table[@id='w0']//td")
        private List<WebElement> test;*/



    public ViewUserInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getBtnUpdate() {
        return btnUpdate;
    }

    public void clickOnUpdateButton() {
        btnUpdate.click();
    }

}
