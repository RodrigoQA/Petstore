package testes;

import core.BaseTest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class CriarPetsTest extends BaseTest {
    @Test
    public void deveCriarOPetDog() throws IOException {
        File body = new File("src/test/resources/pets/dog");
        given()

                .body(body)
                .when()
                .post("/pet")
                .then().log().all()
                .statusCode(200)
                .body("id",is(1))
                .body("category.name",is("dog"))
                .body("status",containsString("available"));

    }
    @Test
    public void deveCriarOPetCat() throws IOException {
        File body = new File("src/test/resources/pets/cat");
        given()

                .body(body)
                .when()
                .post("/pet")
                .then().log().all()
                .statusCode(200)
                .body("id",is(2))
                .body("category.name",is("cat"))
                .body("status",containsString("available"));


    }
    @Test
    public void deveCriarOPetPlatypus() throws IOException {
        File body = new File("src/test/resources/pets/platypus");
        given()

                .body(body)
                .when().log().all()
                .post("/pet")
                .then().log().all()
                .statusCode(200)
                .body("id",is(3))
                .body("category.name",is("platypus"))
                .body("status",containsString("available"));


    }

}
