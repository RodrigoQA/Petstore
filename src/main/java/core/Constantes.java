package core;


import io.restassured.http.ContentType;

public interface Constantes {
    String APP_BASE_URL = "https://petstore.swagger.io/v2";
    //Integer APP_PORT = "";
    String APP_BASE_PATH = "";

    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 20000L;


}
