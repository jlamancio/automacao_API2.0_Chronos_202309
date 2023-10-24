package steps;

import io.cucumber.java.pt.Entao;
import utils.RestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class GenericSteps {

    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {

        assertEquals(status, RestUtils.getResponse().getStatusCode());

    }
}
