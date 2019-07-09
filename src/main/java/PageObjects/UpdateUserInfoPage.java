package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateUserInfoPage {

    @FindBy(id = "users-id")
    private WebElement txtId;
    @FindBy(id = "users-name")
    private WebElement txtName;
    @FindBy(id = "users-username")
    private WebElement txtUserName;
    @FindBy(id = "users-email")
    private WebElement txtEmail;
    @FindBy(id = "users-address")
    private WebElement txtAddress;
    @FindBy(id = "users-phone")
    private WebElement txtPhone;

    public UpdateUserInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void updateUserInfo(String id, String name, String userName, String email, String address, String phone){
        txtId.sendKeys(id);
        txtName.sendKeys(name);
        txtUserName.sendKeys(userName);
        txtEmail.sendKeys(email);
        txtAddress.sendKeys(address);
        txtPhone.sendKeys(phone);
        txtPhone.submit();
    }

    public void clearFields(){
        txtId.clear();
        txtName.clear();
        txtUserName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtPhone.clear();
    }
}
