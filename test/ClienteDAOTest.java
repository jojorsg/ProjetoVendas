package test.java;

import main.java.Cliente;
import main.java.IClienteDAO;
import main.java.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setNome("Josué");
        cliente.setCpf(12345678910L);
        cliente.setCidade("Caucaia");
        cliente.setEnd("Rua 46");
        cliente.setEstado("CE");
        cliente.setNumero(2099);
        cliente.setTel(85999999999L);
        clienteDao.cadastrar(cliente);

    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDao.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Josué Roberto");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Josué Roberto",cliente.getNome());
    }

}