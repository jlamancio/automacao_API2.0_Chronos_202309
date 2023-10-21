package plataformaFlmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import plataformaFlmes.utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTest {
    static String token;

    @BeforeAll
    public static void validarLoginMap() {
        RestUtils.setBaseURI("http://amancio:8080/");

        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@email.com");
        map.put("senha", "123456");

        Response response = RestUtils.post(map, ContentType.JSON, "auth");
        assertEquals(200, response.statusCode());

        token = response.jsonPath().get("token");
    }

    @Test
    public void validarConsultaCategorias() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);

       // Response response = RestUtils.get(header, "categorias");

        RestUtils.get(header, "categorias");
        assertEquals(200, RestUtils.getResponse().statusCode());
        assertEquals("Terror", RestUtils.getResponse().jsonPath().get("tipo[2]"));

        List<String> listTipo = RestUtils.getResponse().jsonPath().get("tipo");
        assertTrue(listTipo.contains("Terror"));

    }

}
