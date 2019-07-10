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

    public void updateUserInfo(User user){
        txtId.sendKeys(String.valueOf(user.getId()));
        txtName.sendKeys(user.getName());
        txtUserName.sendKeys(user.getUsername());
        txtEmail.sendKeys(user.getEmail());
        txtAddress.sendKeys(user.getAddress());
        txtPhone.sendKeys(user.getPhone());
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
