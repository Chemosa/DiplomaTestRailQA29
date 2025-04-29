package api.adapters;

import api.constants.IConstants;
import com.google.gson.Gson;
import utils.PropertyReader;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class BaseAdapter implements IConstants {

    Gson gson = new Gson();
//    String auth = PropertyReader.getProperty("email") + ":" + PropertyReader.getProperty("apiKey");
    String auth = System.getProperty("email") + ":" + System.getProperty("apiKey");
//    String ACCESS_USER_URL = PropertyReader.getProperty("accessAddress");
    String ACCESS_USER_URL = System.getProperty("accessAddress");
    String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

    /**
     * This method sends GET request.
     * @param url
     * @return
     */
    public String get(String url) {
        return
                given()
                        .log().all()
                        .header("Authorization", "Basic " + encodedAuth)
                        .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                        .when()
                        .get(ACCESS_USER_URL + url)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().body().asString();
    }

    /**
     * This method sends POST request.
     * @param url
     * @param body
     * @return
     */
    public String post(String url, String body) {
        return
                given()
                        .log().all()
                        .header("Authorization", "Basic " + encodedAuth)
                        .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                        .body(body)
                        .when()
                        .post(ACCESS_USER_URL + url)
                        .then()
                        .log().all()
                        .extract().body().asString();
    }
}