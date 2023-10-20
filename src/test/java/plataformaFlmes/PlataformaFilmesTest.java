package plataformaFlmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTest {
    static String token;

    @BeforeAll
    public static void validarLoginMap() {
        RestAssured.baseURI = "http://amancio:8080/";

        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@email.com");
        map.put("senha", "123456");

        Response response = post(map, ContentType.JSON, "auth");
        assertEquals(200, response.statusCode());

        token = response.jsonPath().get("token");
    }
    @Test
    public void validarConsultaCategorias() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);

        Response response = get(header,"categorias");
        assertEquals(200, response.statusCode());
    }

    public static Response get(Map<String, String> header, String endPoint) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endPoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response post(Object json, ContentType contentType, String endPoint) {
        return RestAssured.given()
                .log().all()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endPoint)
                .thenReturn();
    }
}
