package StepDefinitions;

import Base.BaseUtils;
import PageObjects.Post;
import cucumber.api.java.en.When;
import com.mashape.unirest.http.exceptions.UnirestException;


public class UpdateUser extends BaseUtils {
    private BaseUtils base;

    public UpdateUser(BaseUtils base) {
        this.base = base;
    }

    @When("^User goes to page$")
    public void userGoesToPage(){
        System.out.println(base.baseURL + base.id);
        base.driver.get(base.baseURL+base.id);
        System.out.println();
    }
}
