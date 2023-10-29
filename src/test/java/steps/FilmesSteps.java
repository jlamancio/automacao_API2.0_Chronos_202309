package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMap;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class FilmesSteps {

    @Dado("que tenha um payload valido de login da API de Filme")
    public void queTenhaUmPayloadValidoDeLoginDaAPIDeFilme() {
        FilmesMap.initAll();

    }

    @Quando("envio uma requisicao do tipo POST de Filme")
    public void envioUmaRequisicaoDoTipoPOSTDeFilme() {
        RestUtils.post(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON, "filmes");

    }

    @Então("armazeno o id que recebo do response de Filme")
    public void armazenoOIdQueReceboDoResponseDeFilme() {
        FilmesMap.id = RestUtils.getResponse().jsonPath().get("id");

    }
    @Quando("realizo uma requisicao do tipo GET de Filme atraves do nome")
    public void realizoUmaRequisicaoDoTipoGETDeFilmeAtravesDoNome() {
        Map<String, Object> param = new HashMap<>();
        String nome = FilmesMap.getFilme().get("nome").toString();
        param.put("nome", nome);
        RestUtils.get(FilmesMap.getHeader(), param, "filmes");
    }

    @E("altero o indice {int} da lista de categorias do filme com os valores")
    public void alteroOIndiceDaListaDeCategoriasDoFilmeComOsValores(int indice, Map<String, String> map ) {
        FilmesMap.getListCategoria().get(indice).putAll(map);
        
    }

    @Quando("realizo uma requisição do tipo PUT de filme")
    public void realizoUmaRequisicaoDoTipoPUTDeFilme() {
    RestUtils.put(FilmesMap.getHeader(), FilmesMap.getFilme(),
            ContentType.JSON, "filmes/" + FilmesMap.id);

    }

    @Quando("realizo uma requisicao do tipo Delete de Filme")
    public void realizoUmaRequisicaoDoTipoDeleteDeFilme() {
        RestUtils.delete(FilmesMap.getHeader(), "filmes/" + FilmesMap.id);
    }
}
