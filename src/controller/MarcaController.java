package controller;

import DAO.MarcaDaoImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cidade;
import model.Marca;

public class MarcaController {

    MarcaDaoImpl dao;

    public MarcaController() {
        dao = new MarcaDaoImpl();
    }

    public void cadastrar(Marca m) {
        dao.cadastrar(m);
    }

    public void deletar(Marca m) {
        dao.deletar(m);
    }

    public Marca pesquisar(String marca) {
        return dao.pesquisar(marca);
    }
   
    public Marca pesquisar(int codigo) {
        return dao.pesquisar(codigo);
    }
    
    public void alterar(Marca m) {
        dao.alterar(m);
    }

    public ArrayList<Marca> selecionarMarcas() {
        return dao.selecionarMarcas();
    }

    public int pegarIdMarca(Marca m) {
        return dao.pegarIdMarca(m);
    }

    public ArrayList<Marca> selecionarMarcas(String nome) {
        return dao.selecionarMarcas(nome);
    }
    
    public ResultSet retornarConsultaSQL(String pesq, int opcao) {
        return dao.retornarConsultaSQL(pesq, opcao);
    }
}
