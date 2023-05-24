import file_for_test.CourierApi;
import file_for_test.DataForLogin;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.sql.SQLException;

import static io.restassured.path.json.JsonPath.given;


public class TestCreateNewCourier {

    String login="11asssdfsd";
    String password="2aasssssdfdf2";
    String firstName="3asdsssdfssa";
    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Checking the creation of a new courier and responding to the request")
    public void createNewCourierAndCheckStatus() {
        CourierApi.createNewCourier(login, password, firstName, "Content-type",
                "application/json", "/api/v1/courier", "ok", true, 201);
        Response responseLogin = CourierApi.loginForDelete(login, password, "Content-type",
                "application/json", "/api/v1/courier/login");
        int token = responseLogin.then().extract().path("id");
        CourierApi.delete(token);
    }


    @Test
    @DisplayName("Checking that it is impossible to create two identical couriers")
    public void createDublicatCourierAndCheckStatus() {
        CourierApi.createCourierStatus("123Ssdas", "12asasdfas3", "12uadsdasdfper", "Content-type",
                "application/json", "/api/v1/courier", 409);
    }


    @Test
    @DisplayName("Test of creating a courier without a single field")
    public void createNewCourierAndCheckStatusFailed() {
        CourierApi.createCourierStatus("Ssdagaadfatas", "", "Stassuadsfasdfasdasdfper", "Content-type",
                "application/json", "/api/v1/courier", 400);
    }

}
