package StepDefinitions;

import Base.BaseUtils;
import PageObjects.UpdateUserInfoPage;
import PageObjects.User;
import PageObjects.ViewUserInfoPage;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static PageObjects.DataViaAPI.getJsonNodeHttpResponse;


public class UpdateUser extends BaseUtils {
    private BaseUtils base;

    public UpdateUser(BaseUtils base) {
        this.base = base;
    }

    @When("^User goes to page$")
    public void userGoesToPage() {
        //Navigate to the page
        base.driver.get(base.baseURL + base.id);
    }

    @And("^User clicks on update button$")
    public void userClicksOnUpdateButton() {
        //Click on update button
        base.viewUserInfo = new ViewUserInfoPage(base.driver);
        base.viewUserInfo.clickOnUpdateButton();
    }

    @And("^User puts new values in all Fields and clicks Update$")
    public void userPutsNewValuesInAllFieldsAndClicksUpdate() {
        //Create the objects to update user
        base.updateUser = new UpdateUserInfoPage(base.driver);
        base.viewUserInfo = new ViewUserInfoPage(base.driver);
        //Make sure you are on the right page
        Assert.assertEquals(base.driver.getTitle(), "Update Users: " + base.user.getName());
        WebDriverWait wait = new WebDriverWait(base.driver, 3);

        //Clear fields first and then input the new values
        base.updateUser.clearFields();
        base.updateUser.updateUserInfo(new User("432 central str, St Paul", "874-875-8274", "Doug McGregor",
                14, "dmcgregor@tester.org", "dmcgregor43"));
        //Make sure button loads before moving on
        try {
            wait.until(ExpectedConditions.visibilityOf(base.viewUserInfo.getBtnUpdate()));
        } catch (Exception e) {
            System.out.println("User not updated");
        }
    }

    @Then("^User information is updated$")
    public void userInformationIsUpdated() throws UnirestException {
        //setup gson
        base.gson = new GsonBuilder().create();
        //Call the api to get the user information
        HttpResponse<JsonNode> jsonResponse = getJsonNodeHttpResponse(base.id);
        //make sure results are being returned
        Assert.assertNotNull(jsonResponse.getBody());
        Assert.assertEquals(200, jsonResponse.getStatus());

        //Deserialize and validate the updates
        base.user = base.gson.fromJson(jsonResponse.getBody().toString(), User.class);
        Assert.assertEquals(base.user.getAddress(), "432 central str, St Paul");
        Assert.assertEquals(base.user.getEmail(), "dmcgregor@tester.org");
        Assert.assertEquals(base.user.getName(), "Doug McGregor");
        Assert.assertEquals(base.user.getPhone(), "874-875-8274");
        Assert.assertEquals(base.user.getUsername(), "dmcgregor43");
        Assert.assertEquals(base.user.getId(), base.id);
    }


}
