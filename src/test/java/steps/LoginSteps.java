package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.RestUtils;

import java.util.Map;

public class LoginSteps {

    String url = "http://amancio:8080/";

    @Dado("que tenha um payload valido de login da API PlataformaFilmes")
    public void queTenhaUmPayloadValidoDeLoginDaAPIPlataformaFilmes() {

        LoginMap.initLogin();
        RestUtils.setBaseURI(url);
    }

    @Quando("envio uma requisicao do tipo POST de Login")
    public void envioUmaRequisicaoDoTipoPOSTDeLogin() {
        RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");
    }

    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {
        LoginMap.token = RestUtils.getResponse().jsonPath().get("token");
    }

    @Dado("que tenha um payload de Login da API PlataformaFilmes com as seguintes informacoes")
    public void queTenhaUmPayloadDeLoginDaAPIPlataformaFilmesComAsSeguintesInformacoes(Map<String, String> map) {
        LoginMap.initLogin();
        RestUtils.setBaseURI(url);
        LoginMap.getLogin().putAll(map);

    }


}
