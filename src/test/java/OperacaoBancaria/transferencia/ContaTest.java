package OperacaoBancaria.transferencia;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente jose = new Cliente("José Luis Amancio", "33334444555", "01010012-7");
    Cliente flavia = new Cliente("Flavia Regina Boconcelo", "12121223231", "123456789-1");
    Conta contaJose = new Conta("01222", "123456", 1000.00, jose);
    Conta contaFlavia = new Conta("33445", "678590", 1000.00, flavia);

    @Test
    @DisplayName("Tranferir valores entre contas")
    public void realizarTransaca() {

        contaFlavia.realizarTransferencia(500.00, contaJose);
        assertEquals(500.00, contaFlavia.getSaldo());
        assertEquals(1500.00, contaJose.getSaldo());

    }

    @Test
    @DisplayName("Tranfererir valores entre contas - Valores inválidos")
    public void realizarTransacaInvalida() {

        boolean transfJl = contaFlavia.realizarTransferencia(1500.00, contaJose);
        assertFalse(transfJl);
        boolean transfFl = contaJose.realizarTransferencia(1500.00, contaFlavia);
        assertFalse(transfFl);

    }

    @Test
    @DisplayName("Realizar saque das Contas")
    public void realizarSaqueDasContas() {

        boolean saqueJl = contaJose.realizarSaque(500.00);
        assertTrue(saqueJl);
        boolean saqueFl = contaFlavia.realizarSaque(500.00);
        assertTrue(saqueFl);
    }

    @Test
    @DisplayName("Realizar saque das Contas - Valores Invalidos")
    public void realizarSaqueDasContasValoresInvalidos() {

        boolean saqueJl = contaJose.realizarSaque(2500.00);
        assertFalse(saqueJl);
        boolean saqueFl = contaFlavia.realizarSaque(2500.00);
        assertFalse(saqueFl);
    }

    @Test
    @DisplayName("Validar nome do Cliente nos Cadastros")
    public void validarCadastroDeClientes(){

        String nomeDoClienteJ = contaJose.getProprietario().getNome();
        assertEquals("José Luis Amancio", nomeDoClienteJ);
        String nomeDoClienteF = contaFlavia.getProprietario().getNome();
        assertEquals("Flavia Regina Boconcelo", nomeDoClienteF);

    }

    @Test
    @DisplayName("Validar numero da conta")
    public void validarNumeroDaConta() {

        String contaJl = contaJose.getNumeroConta();
        assertEquals("123456", contaJl);
        String contaFl = contaFlavia.getNumeroConta();
        assertEquals("678590", contaFl);

    }

    @Test
    @DisplayName("Validar numero da agencia")
    public void validarNumeroDaAgencia() {

        String agenciaJl = contaJose.getAgencia();
        assertEquals("01222", agenciaJl);
        String agenciaFl = contaFlavia.getAgencia();
        assertEquals("33445", agenciaFl);

    }

    @Test
    @DisplayName("Validar Cpf")
    public void validarCpf() {

        String cpfJl = jose.getCpf();
        assertEquals("33334444555", cpfJl);
        String cpfFl = flavia.getCpf();
        assertEquals("12121223231", cpfFl);

    }

    @Test
    @DisplayName("Validar Rg")
    public void validarRg() {

        String rgJl = jose.getRg();
        assertEquals("01010012-7", rgJl);
        String rgFl = flavia.getRg();
        assertEquals("123456789-1", rgFl);

    }

}



