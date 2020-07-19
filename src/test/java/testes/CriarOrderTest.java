package testes;

import core.BaseTest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CriarOrderTest extends BaseTest {
    @Test
    public void deveVenderPerryParaAnaMaia() throws IOException {
        File body = new File("src/test/resources/orders/orderPlatypus");
        given()

                .body(body)
                .when()
                .post("/store/order")
                .then().log().all()
                .statusCode(200)
                .body("status",is("placed"));

    }
    @Test
    public void deveVenderSnoopyParaRodrigoMendes() throws IOException {
        File body = new File("src/test/resources/orders/orderDog");
        given()

                .body(body)
                .when()
                .post("/store/order")
                .then().log().all()
                .statusCode(200)
                .body("status",is("placed"));

    }
    @Test
    public void deveVenderSnoopyParaTatianaVanconcelos() throws IOException {
        File body = new File("src/test/resources/orders/orderDog");
        given()

                .body(body)
                .when()
                .post("/store/order")
                .then().log().all()
                .statusCode(200)
                .body("status", is("placed"));
    }
}
