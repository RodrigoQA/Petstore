package testes;

import core.BaseTest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AtualizarStatusTest extends BaseTest {
    @Test
    public void deveAtualizarStatusDaOrdemDeVendaDoPerryParaApproved() throws IOException {
        File body_json = new File("src/test/resources/orders/orderPlatypus");
        String content = new String(Files.readAllBytes(body_json.toPath()));
        String body = content.replace("placed","approved");
        given()

                .body(body)
                .when()
                .post("/store/order")
                .then().log().all()
                .statusCode(200)
                .body("status", is("approved"));
    }
    @Test
    public void deveAtualizarStatusDaOrdemDeVendaDoSnoopyParaApproved() throws IOException {
        File body_json = new File("src/test/resources/orders/orderDog");
        String content = new String(Files.readAllBytes(body_json.toPath()));
        String body = content.replace("placed","approved");
        given()

                .body(body)
                .when()
                .post("/store/order")
                .then().log().all()
                .statusCode(200)
                .body("status", is("approved"));
    }
    @Test
    public void deveAtualizarStatusDaOrdemDeVendaDoBichentoParaDelivered() throws IOException {
        File body_json = new File("src/test/resources/orders/orderCat");
        String content = new String(Files.readAllBytes(body_json.toPath()));
        String body = content.replace("placed","delivered");
        given()

                .body(body)
                .when()
                .post("/store/order")
                .then().log().all()
                .statusCode(200)
                .body("status", is("delivered"));
    }

    }
