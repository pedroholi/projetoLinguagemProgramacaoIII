package DAO;

import java.util.ArrayList;
import model.Cliente;

public interface ClienteDAO {
    
    public void cadastrar(Cliente cid);
    
    public void deletar(Cliente cid);
    
    public Cliente pesquisar(String cidade);
    
    public Cliente pesquisar(int codigo);
    
    public Cliente pesquisarCPF(String cpf);
    
    public void alterar(Cliente cid);
    
    public ArrayList<Cliente> selecionarClientes();
    
    public Cliente pesquisarClienteNome(String nome);
    
    public ArrayList<Cliente> pesquisarClientes(String nome);
    
    public int pegarIdCliente(Cliente cid); 
    
}

