package testes;

import core.BaseTest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ConsultarOrdersTest extends BaseTest {
    @Test
    public void deveConsultarOStatusDaOrderDoPerry() throws IOException {

        given()
                .when()
                .get("/store/order/3")
                .then().log().all()
                .statusCode(200)
                .body("petId", is(3))
                .body("quantity", is(1))
                .body("status", is("approved"));


    }
    @Test
    public void deveConsultarOStatusDaOrderDoSnoopy() throws IOException {

        given()
                .when()
                .get("/store/order/1")
                .then().log().all()
                .statusCode(200)
                .body("petId", is(1))
                .body("quantity", is(1))
                .body("status", is("approved"));


    }
    @Test
    public void deveConsultarOStatusDaOrderDoBichento () throws IOException {

        given()
                .when()
                .get("/store/order/2")
                .then().log().all()
                .statusCode(200)
                .body("petId", is(2))
                .body("quantity", is(1))
                .body("status", is("delivered"));


    }
}