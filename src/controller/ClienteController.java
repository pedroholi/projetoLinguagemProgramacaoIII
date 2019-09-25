package controller;

import DAO.ClienteDaoImpl;
import java.util.ArrayList;
import model.Cliente;

public class ClienteController {

    ClienteDaoImpl dao;

    public ClienteController() {
        dao = new ClienteDaoImpl();
    }

    public void cadastrar(Cliente cli) {
        dao.cadastrar(cli);
    }

    public void deletar(Cliente cli) {
        dao.deletar(cli);
    }

    public Cliente pesquisar(String cli) {
        return dao.pesquisar(cli);
    }
   
    public Cliente pesquisar(int codigo) {
        return dao.pesquisar(codigo);
    }
    
    public void alterar(Cliente cli) {
        dao.alterar(cli);
    }

    public ArrayList<Cliente> selecionarClientes() {
        return dao.selecionarClientes();
    }

    public int pegarIdCliente(Cliente cli) {
        return dao.pegarIdCliente(cli);
    }

    public Cliente selecionarClienteCPF(String cpf) {
        return dao.pesquisarCPF(cpf);
    }
    
    public Cliente pesquisarClientesNome(String nome) {
        return dao.pesquisarClienteNome(nome);
    }
    
    public ArrayList<Cliente> pesquisarClientes(String nome){
       return dao.pesquisarClientes(nome);
    }
}
