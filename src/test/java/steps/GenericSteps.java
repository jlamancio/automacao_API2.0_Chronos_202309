package steps;

import io.cucumber.java.pt.Entao;
import org.junit.jupiter.api.Assertions;
import utils.RestUtils;

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


}
