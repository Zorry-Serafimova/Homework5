package Base;

import PageObjects.*;
import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;


public class BaseUtils {
    public WebDriver driver;
    public String baseURL;
    public User user;
    public int id;
    public UpdateUserInfoPage updateUser;
    public ViewUserInfoPage viewUserInfo;
    public Gson gson;
}