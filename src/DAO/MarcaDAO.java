package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Marca;

public interface MarcaDAO {
    
    public void cadastrar(Marca m);
    
    public void deletar(Marca m);
    
    public Marca pesquisar(String marca);
    
    public Marca pesquisar(int codigo);
    
    public void alterar(Marca m);
    
    public ArrayList<Marca> selecionarMarcas();
    
    public ArrayList<Marca> selecionarMarcas(String nome);
    
    public int pegarIdMarca(Marca m);
    
    public ResultSet retornarConsultaSQL(String pesq, int opcao);
    
}

