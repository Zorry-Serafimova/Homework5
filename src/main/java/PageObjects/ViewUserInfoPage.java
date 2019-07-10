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
   /* @FindBy(css = "td")
    private List<WebElement> tblValues;

    @FindBy(id = "w0")
    private WebElement idCol;

@FindBy (xpath = "//table[@id='w0']//td")
        private List<WebElement> test;*/



    public ViewUserInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /*public void printtbl(WebDriver driver, String value) {
        System.out.println(idCol.getText() + " table");
        WebElement rows = driver.findElement(By.xpath("//td[contains(text(),'"+ value + "')]"));
        System.out.println("size: " + test.size());
        for (WebElement el : tblValues) {
            System.out.println("values: " + el.getText());
        }
    }*/

    public void clickOnUpdateButton() {
        btnUpdate.click();
    }

}
