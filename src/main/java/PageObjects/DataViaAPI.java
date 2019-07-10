package PageObjects;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class DataViaAPI {

    public static HttpResponse<JsonNode> getJsonNodeHttpResponse(String postUserInString) throws UnirestException {
        return Unirest.post("https://seleniumclass.000webhostapp.com/api/v1/users")
                .header("Content-Type", "application/json")
                .body(postUserInString)
                .asJson();
    }

    public static HttpResponse<JsonNode> getJsonNodeHttpResponse(int id) throws UnirestException {
        return Unirest.get("https://seleniumclass.000webhostapp.com/api/v1/users/" + id)
                .header("Content-Type", "application/json")
                .asJson();
    }
}
