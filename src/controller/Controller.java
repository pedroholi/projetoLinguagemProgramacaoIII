package controller;

import java.util.ArrayList;
import model.Cidade;

public interface Controller {

    public void cadastrar(Cidade cid);
    
    public void deletar(Cidade cid);
    
    public Cidade pesquisar(String cidade);
    
    public Cidade pesquisar(int codigo);
    
    public void alterar(Cidade cid);
    
    public ArrayList<Cidade> selecionarCidades();
    
    public ArrayList<Cidade> selecionarCidadesUF(String uf);
    
    public ArrayList<Cidade> pesquisarCidadesNome(String uf);
    
    public ArrayList<Cidade> pesquisarCidades(String nome);
    
    public int pegarIdCidade(Cidade cid);
    
    
    
}
