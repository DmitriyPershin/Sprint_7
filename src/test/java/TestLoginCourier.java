import fileForTest.DataForLogin;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;


public class TestLoginCourier {


    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Verification of a request with a successful login and password")
    public void checkingGoodLoginCourier() {
        DataForLogin login = new DataForLogin("123Ssasdgdagadfsdatas", "12asasdfdfas3");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(login)
                        .when()
                        .post("/api/v1/courier/login");
        response.then().assertThat().body("id", notNullValue())
                .and()
                .statusCode(200);
    }

    @Test
    @DisplayName("Checking a request with a non-existent login-password pair")
    public void checkingFailedLoginCourier() {
        DataForLogin login = new DataForLogin("123Ssasdgasddagadfsdatas", "12asasdasasdfdfas3");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(login)
                        .when()
                        .post("/api/v1/courier/login");
        response.then()
                .statusCode(404);
    }

    @Test
    @DisplayName("Request verification without login or password")
    public void checkingFailedLoginCourierForNotPassword() {
        DataForLogin login = new DataForLogin("123Ssasdgasddagadfsdatas", "");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(login)
                        .when()
                        .post("/api/v1/courier/login");
        response.then()
                .statusCode(400);
    }
}