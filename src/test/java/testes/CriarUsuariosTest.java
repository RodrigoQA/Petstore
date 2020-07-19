package testes;

import core.BaseTest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class CriarUsuariosTest extends BaseTest {

    @Test
    public void deveCriarUmaListaComTresUsuarios() throws IOException {
        File body = new File("src/test/resources/users/usuarios");
        given()

                .body(body)
                .when()
                .post("/user/createWithArray")
                .then().log().all()
                .statusCode(200)
                .body("message",containsString("ok"));



    }


}
