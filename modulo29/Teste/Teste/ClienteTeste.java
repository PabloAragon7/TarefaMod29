package Teste;

import dao.ClienteDAO;
import dao.IClienteDAO;
import domin.Cliente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTeste {

    private IClienteDAO clienteDAO;

    @Test
    public void cadastrarTeste() throws Exception{
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Rodrigo Pires");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue (countCad ==1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);

    }

    @Test

    public void buscarTeste() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Rodrigo Pires");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad ==1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel= clienteDAO.excluir(clienteBD);
                assertTrue(countDel==1);

    }

    public void excluirTeste() throws Exception {

        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Rodrigo Pires");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);

    }

        public void bucarTodosTeste() throws Exception{

            clienteDAO = new ClienteDAO();

            Cliente cliente = new Cliente();
            cliente.setCodigo("10");
            cliente.setNome("Rodrigo Pires");
            Integer countCad = clienteDAO.cadastrar(cliente);
            assertTrue(countCad == 1);

            Cliente clientes = new Cliente();
            clientes.setCodigo("20");
            clientes.setNome("Teste");
            Integer countCad2 = clienteDAO.cadastrar(clientes);
            assertTrue(countCad2 == 1);

            List<Cliente> list = clienteDAO.bucarTodos();
            assertNotNull(list);
            assertEquals(2, list.size());

            int countDel=0;
            for (Cliente cli:list){
                clienteDAO.excluir(cli);
                countDel++;
            }
            assertEquals(list.size(), countDel);

            list = clienteDAO.bucarTodos();
            assertEquals(list.size(), 0);

    }

    public void atualizarTeste() throws Exception{
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Rodrigo Pires");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("20");
        clienteBD.setNome("outroo nome");
        Integer countUpdate = clienteDAO.atualizar(clienteBD);
        assertTrue(countUpdate==1);

        Cliente clienteBD2 = clienteDAO.buscar("20");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> list = clienteDAO.bucarTodos();
        for (Cliente cli : list){
            clienteDAO.excluir(cli);
        }

    }


}
