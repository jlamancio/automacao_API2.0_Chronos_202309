package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.junit.jupiter.api.Assertions;
import utils.RestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenericSteps {

    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        assertEquals(status, RestUtils.getResponse().getStatusCode());

    }

    @Entao("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String key, String value) {
        assertEquals(value, RestUtils.getResponse().jsonPath().get(key));

    }


    @E("valido uma que recebo uma lista vazia no response")
    public void validoUmaQueReceboUmaListaVaziaNoResponse() {
        Assertions.assertEquals(new ArrayList<>(),RestUtils.getResponse().jsonPath().get());
    }
}
