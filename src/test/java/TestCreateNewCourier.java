import file_for_test.CourierApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;



public class TestCreateNewCourier {


    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Checking the creation of a new courier and responding to the request")
    public void createNewCourierAndCheckStatus() {
        CourierApi.createNewCourier("1sadaadsassddssftsas", "12asasaafsadssdfaassadfas3", "rfa4ssasdsdsasafper", "Content-type",
                "application/json", "/api/v1/courier", "ok", true, 201);
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
//    Я не понимаю как чистить данные без доступа к бд, в спринте не могу нигде найти об этом информацию
//    нигде не нашел. Тут я пытался получить айдишник созданного курьра и запихнуть его в делит запрос
//    Может есть волшебная команда на очистку данных?:))))
//    @After
//    public void cleanup() throws SQLException {
//        DataForLogin loginCourier = new DataForLogin("1sadaadsasddssftsas", "12asasaafdssdfaassadfas3");
//        Response response = given()
//                .header("Content-type", "application/json")
//                       .and()
//                       .body(loginCourier)
//                        .when()
//                .post("/api/v1/courier/login");
//
//        given()
//                .delete("/api/v1/courier/:id", response)
//                .then().assertThat().statusCode(200);
//    }
}
