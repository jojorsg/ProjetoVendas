package test.java;

import main.java.Cliente;
import main.java.ClienteService;
import main.java.IClienteDAO;
import main.java.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setNome("Josué");
        cliente.setCpf(12345678910L);
        cliente.setCidade("Caucaia");
        cliente.setEnd("Rua 46");
        cliente.setEstado("CE");
        cliente.setNumero(2099);
        cliente.setTel(85999999999L);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Josué Roberto");
        clienteService.alterar(cliente);

        Assert.assertEquals("Josué Roberto",cliente.getNome());
    }
}