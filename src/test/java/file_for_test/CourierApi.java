package file_for_test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CourierApi {

    public static void loginCourierNotNull(String login, String password, String headerType, String json, String addressApi, String body, int statusCode) {
        DataForLogin loginCourier = new DataForLogin(login, password);
        Response response =
                given()
                        .header(headerType, json)
                        .and()
                        .body(loginCourier)
                        .when()
                        .post(addressApi);
        response.then().assertThat().body(body, notNullValue())
                .and()
                .statusCode(statusCode);
    }

    public static void loginCourierError(String login, String password, String headerType, String json, String addressApi, int statusCode) {
        DataForLogin loginCourier = new DataForLogin(login, password);
        Response response =
                given()
                        .header(headerType, json)
                        .and()
                        .body(loginCourier)
                        .when()
                        .post(addressApi);
        response.then()
                .statusCode(statusCode);
    }
    public static void createNewCourier(String login, String password,String firstName, String headerType, String json, String addressApi, String field,boolean operand, int statusCode) {
        DataForCourier courier = new DataForCourier(login, password,firstName);
        Response response =
                given()
                        .header(headerType, json)
                        .and()
                        .body(courier)
                        .when()
                        .post(addressApi);
        response.then().assertThat().body(field, equalTo(operand))
                .and()
                .statusCode(statusCode);
    }

    public static void createCourierStatus(String login, String password,String firstName, String headerType, String json, String addressApi, int statusCode) {
        DataForCourier courier = new DataForCourier(login, password, firstName);
        Response response =
                given()
                        .header(headerType, json)
                        .and()
                        .body(courier)
                        .when()
                        .post(addressApi);
        response.then()
                .statusCode(statusCode);
    }

}
