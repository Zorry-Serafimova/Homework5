package StepDefinitions;

import Base.BaseUtils;
import PageObjects.UpdateUserInfoPage;
import PageObjects.User;
import PageObjects.ViewUserInfoPage;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;

import static PageObjects.DataViaAPI.getJsonNodeHttpResponse;


public class UpdateUser extends BaseUtils {
    private BaseUtils base;

    public UpdateUser(BaseUtils base) {
        this.base = base;
    }

    @When("^User goes to page$")
    public void userGoesToPage() {
        base.driver.get(base.baseURL + base.id);
        // base.driver.get(base.baseURL+7);
    }

    @And("^User clicks on update button$")
    public void userClicksOnUpdateButton() {
        base.viewUserInfo = new ViewUserInfoPage(base.driver);
        base.viewUserInfo.clickOnUpdateButton();
    }

    @And("^User puts new values in all Fields and clicks Update$")
    public void userPutsNewValuesInAllFieldsAndClicksUpdate() throws InterruptedException {
        base.updateUser = new UpdateUserInfoPage(base.driver);
        Assert.assertEquals(base.driver.getTitle(), "Update Users: " + base.user.getName());
        /*base.user = new User("432 central str, St Paul", "874-875-8274", "Doug McGregor",
                14, "dmcgregor@tester.org", "dmcgregor43");*/
        base.updateUser.clearFields();
        base.updateUser.updateUserInfo(new User("432 central str, St Paul", "874-875-8274", "Doug McGregor",
                14, "dmcgregor@tester.org", "dmcgregor43"));
        Thread.sleep(3000);
    }

    @Then("^User information is updated$")
    public void userInformationIsUpdated() throws UnirestException {
        base.gson = new GsonBuilder().create();
        HttpResponse<JsonNode> jsonResponse = getJsonNodeHttpResponse(base.id);
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
