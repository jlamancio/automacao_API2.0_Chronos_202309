package plataformaFlmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlataformaFilmesTest {

    @Test
    public void validarLogin() {

        RestAssured.baseURI = "http://amancio:8080/";

        String json = "{" +
                "    \"email\": \"aluno@email.com\"," +
                "    \"senha\": \"123456\"" +
                "}";


        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("auth")
                .thenReturn();

        assertEquals(200, response.statusCode());

        String token = response.jsonPath().get("token");




    }


}
