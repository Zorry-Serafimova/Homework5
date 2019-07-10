package StepDefinitions;

import Base.BaseUtils;
import PageObjects.User;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.Given;
import org.testng.Assert;

import static PageObjects.DataViaAPI.getJsonNodeHttpResponse;

public class CreateUser extends BaseUtils {

    private BaseUtils base;

    public CreateUser(BaseUtils base) {
        this.base = base;
    }

    @Given("^User is created via api$")
    public void userIsCreatedViaApi() throws UnirestException {

        base.user = new User("385 Irving plaza, suite 1700", "574-4837-9843", "Lucy Smith", 13, "alf@alf.net", "lsmith84");
        base.gson = new GsonBuilder().create();
        //Serialize the object so it can be used in the API to setup user
        String postUserInString = base.gson.toJson(base.user);

        HttpResponse<JsonNode> jsonResponse = getJsonNodeHttpResponse(postUserInString);
        //Make sure call is successful
        Assert.assertNotNull(jsonResponse.getBody());
        Assert.assertEquals(201, jsonResponse.getStatus());

        //Deserialize to get the ID to be used to navigate to User page
        base.user = base.gson.fromJson(jsonResponse.getBody().toString(), User.class);
        base.id = base.user.getId();
    }


}
