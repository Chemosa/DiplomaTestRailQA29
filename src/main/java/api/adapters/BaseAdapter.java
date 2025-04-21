package api.adapters;

import api.constants.IConstants;
import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter implements IConstants {
    Gson gson = new Gson();

    public String post(String url, String body) {
        return
                given()
                        .log().all()
                        .header(email, API_KEY)
                        .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                        .body(body)
                        .when()
                        .post(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().body().asString();
    }
}
