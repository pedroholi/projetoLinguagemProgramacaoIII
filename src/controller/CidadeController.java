package controller;

import DAO.CidadeDaoImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cidade;

public class CidadeController {

    CidadeDaoImpl dao;

    public CidadeController() {
        dao = new CidadeDaoImpl();
    }

    public void cadastrar(Cidade cid) {
        dao.cadastrar(cid);
    }

    public void deletar(Cidade cid) {
        dao.deletar(cid);
    }

    public Cidade pesquisar(String cidade) {
        return dao.pesquisar(cidade);
    }
   
    public Cidade pesquisar(int codigo) {
        return dao.pesquisar(codigo);
    }
    
    public void alterar(Cidade cid) {
        dao.alterar(cid);
    }

    public ArrayList<Cidade> selecionarCidades() {
        return dao.selecionarCidades();
    }

    public int pegarIdCidade(Cidade cid) {
        return dao.pegarIdCidade(cid);
    }

    public ArrayList<Cidade> selecionarCidadesUF(String uf) {
        return dao.selecionarCidadesUF(uf);
    }
    
    public ArrayList<Cidade> pesquisarCidadesNome(String nome) {
        return dao.selecionarCidadesUF(nome);
    }
    
    public ArrayList<Cidade> pesquisarCidades(String nome){
       return dao.pesquisarCidades(nome);
    }
    
    public ResultSet retornarConsultaSQL(String pesq, int opcao) {
        return dao.retornarConsultaSQL(pesq, opcao);
    }
}
