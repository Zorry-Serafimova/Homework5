package Base;

import PageObjects.*;
import StepDefinitions.UpdateUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.openqa.selenium.WebDriver;

public class BaseUtils {
    public WebDriver driver;
    public String baseURL;
    public User user;
    public Post postUser;
    public int id;
    public UpdateUserInfoPage updateUser;
    public ViewUserInfoPage viewUserInfo;
    public Gson gson;

}