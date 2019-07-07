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
        User user = new User(
                70, "testZ", "TestUZ", "testu_z@gmail.com", "23 Main str, Hollywood, CA",
                "324-854-5768");

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String jsonInString = gson.toJson(user);
        System.out.println(jsonInString);
        HttpResponse<JsonNode> jsonResponse = Unirest.post("https://seleniumclass.000webhostapp.com/api/v1/users")
                .header("accept", "application/json")
                .body(jsonInString)
                .asJson();
        System.out.println(jsonResponse.getBody());
        System.out.println(jsonResponse.getStatus());
        Assert.assertNotNull(jsonResponse.getBody());
     //   Assert.assertEquals(201, jsonResponse.getStatus());

        /*base.postUser = new Post();
        base.postUser = gson.fromJson(jsonResponse.getBody().toString(), Post.class);
        base.id = base.postUser.getId();*/
    }
}
