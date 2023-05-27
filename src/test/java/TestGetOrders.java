import file_for_test.OrderApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

public class TestGetOrders {
    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Checking the receipt of the list of orders")
    public void checkGetOrders() {
        OrderApi.testGetOrders();
    }
}
