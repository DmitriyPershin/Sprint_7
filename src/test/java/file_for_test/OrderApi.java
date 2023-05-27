package file_for_test;

import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderApi {
    public static <TestCreateOrders> void testOrders(List<TestCreateOrders> testCreateOrderss) {
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(testCreateOrderss)
                        .when()
                        .post("/api/v1/orders");
        response.then().assertThat().body("track", notNullValue())
                .and()
                .statusCode(201);
    }

    public static void testGetOrders() {
        Response response =
                given().
                        get("/api/v1/orders");
        response.then().assertThat().body("orders", notNullValue())
                .and()
                .statusCode(200);
    }
}
