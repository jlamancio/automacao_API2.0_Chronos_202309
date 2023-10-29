package plataformaFlmes;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTest {
    @BeforeAll
    public static void validarLoginMap() {
        RestUtils.setBaseURI("http://amancio:8080/");
        LoginMap.initLogin();

        Response response = RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");
        assertEquals(200, response.statusCode());

        LoginMap.token = response.jsonPath().get("token");

    }

    @Test
    public void validarConsultaCategorias() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + LoginMap.token);

       // Response response = RestUtils.get(header, "categorias");

        RestUtils.get(header, "categorias");
        assertEquals(200, RestUtils.getResponse().statusCode());
        assertEquals("Terror", RestUtils.getResponse().jsonPath().get("tipo[2]"));

        List<String> listTipo = RestUtils.getResponse().jsonPath().get("tipo");
        assertTrue(listTipo.contains("Terror"));

    }

}
