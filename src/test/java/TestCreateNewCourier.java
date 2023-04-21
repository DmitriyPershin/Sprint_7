import fileForTest.DataForCourier;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class TestCreateNewCourier {


    @Before
    public void setUp() {
        RestAssured.baseURI ="http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Checking the creation of a new courier and responding to the request")
    public void createNewCourierAndCheckStatus(){

        DataForCourier login = new DataForCourier("1sadaasftsas", "12asasaafdassadfas3", "rfa4ssdsafper");
        Response response =
         given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(login)
                        .when()
                        .post("/api/v1/courier");
        response.then().assertThat().body("ok", equalTo(true))
                .and()
                .statusCode(201);
    }


    @Test
    @DisplayName("Checking that it is impossible to create two identical couriers")
    public void createDublicatCourierAndCheckStatus(){
        DataForCourier login = new DataForCourier("123Ssdagadfsdatas", "12asasdfdfas3", "123Stassuadsasdfafasdasdfper");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(login)
                        .when()
                        .post("/api/v1/courier");
        response.then()
                .statusCode(409);
    }


    @Test
    @DisplayName("Test of creating a courier without a single field")
    public void createNewCourierAndCheckStatusFailed(){
        DataForCourier login = new DataForCourier("Ssdagaadfatas", "", "Stassuadsfasdfasdasdfper");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(login)
                        .when()
                        .post("/api/v1/courier");
        response.then()
                .statusCode(400);
    }
}
