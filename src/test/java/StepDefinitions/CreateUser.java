package StepDefinitions;

import Base.BaseUtils;
import PageObjects.Post;
import PageObjects.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.Given;
import org.testng.Assert;

public class CreateUser extends BaseUtils {

    private BaseUtils base;

    public CreateUser(BaseUtils base) {
        this.base = base;
    }

    @Given("^User is created via api$")
    public void userIsCreatedViaApi() throws UnirestException {
        base.user = new User("testAddress", "574-4837-9843", "testname", 13, "alf@alf.net", "Alfie");
        base.gson = new GsonBuilder().create();

        String postUserInString = base.gson.toJson(base.user);
        HttpResponse<JsonNode> jsonResponse = Unirest.post("https://seleniumclass.000webhostapp.com/api/v1/users")
                .header("Content-Type", "application/json")
                .body(postUserInString)
                .asJson();
        Assert.assertNotNull(jsonResponse.getBody());
        Assert.assertEquals(201, jsonResponse.getStatus());

        base.postUser = new Post();
        base.postUser = base.gson.fromJson(jsonResponse.getBody().toString(), Post.class);
        base.id = base.postUser.getId();
    }
}
