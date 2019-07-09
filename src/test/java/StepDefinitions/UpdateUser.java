package StepDefinitions;

import Base.BaseUtils;
import PageObjects.Post;
import PageObjects.UpdateUserInfoPage;
import PageObjects.User;
import PageObjects.ViewUserInfoPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;


public class UpdateUser extends BaseUtils {
    private BaseUtils base;

    public UpdateUser(BaseUtils base) {
        this.base = base;
    }

    @When("^User goes to page$")
    public void userGoesToPage() {
        base.driver.get(base.baseURL+base.id);
    }

    @And("^User clicks on update button$")
    public void userClicksOnUpdateButton() {
        base.viewUserInfo = new ViewUserInfoPage(base.driver);
        base.viewUserInfo.clickOnUpdateButton();
    }

    @And("^User puts new values in all Fields and clicks Update$")
    public void userPutsNewValuesInAllFieldsAndClicksUpdate() {
        base.updateUser = new UpdateUserInfoPage(base.driver);
        Assert.assertEquals(base.driver.getTitle(), "Update Users: " + base.user.getName());
        /*base.updateUser.clearFields();
        base.updateUser.updateUserInfo("4","updateName", "upUser", "upEmail", "upAddress",
                "upPhone");*/
    }

    @Then("^User information is updated$")
    public void userInformationIsUpdated() {
        System.out.println("Working on it");
    }
}
