import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class TestCreateOrders {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final String color;

    public TestCreateOrders(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String color){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.metroStation=metroStation;
        this.phone=phone;
        this.rentTime=rentTime;
        this.deliveryDate=deliveryDate;
        this.comment=comment;
        this.color=color;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"Vasya", "Pupkin","Pushkina1","Bolshaya1","+79212116771",5,"11.02.2023","Lalalalaasdlal","BLACK"},
                {"Gena", "Pupkin","Pushkina2","Bolshaya2","+79212116772",5,"12.02.2023","Lalalhsalalal","GREY"},
                {"Sasha", "Pupkin","Pushkina3","Bolshaya3","+79212116773",5,"13.02.2023","Lalaldasalalal","BLACK,GREY"},
                {"Lena", "Pupkin","Pushkina4","Bolshaya4","+79212116774",5,"14.02.2023","Lalalaxczxlalal",""}
        });
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Checking the creation of sales with different data")
    public void CheckTestCreateOrders(){
        List<TestCreateOrders> testCreateOrderss = new ArrayList<TestCreateOrders>();
        testCreateOrderss.add(new TestCreateOrders(firstName,lastName,address,metroStation,phone,rentTime,deliveryDate,comment,color));
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
}
