import file_for_test.CourierApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;


public class TestLoginCourier {


    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Verification of a request with a successful login and password")
    public void checkingGoodLoginCourier() {
        CourierApi.loginCourierNotNull("1fa", "2jfd", "Content-type",
                "application/json", "/api/v1/courier/login", "id", 200);
    }

    @Test
    @DisplayName("Checking a request with a non-existent login-password pair")
    public void checkingFailedLoginCourier() {
        CourierApi.loginCourierError("123Ssasdgasddagadfsdatas", "12asasdasasdfdfas3", "Content-type",
                "application/json", "/api/v1/courier/login", 404);
    }

    @Test
    @DisplayName("Request verification without login or password")
    public void checkingFailedLoginCourierForNotPassword() {
        CourierApi.loginCourierError("123Ssasdgasddagadfsdatas", "", "Content-type",
                "application/json", "/api/v1/courier/login", 400);
    }
}