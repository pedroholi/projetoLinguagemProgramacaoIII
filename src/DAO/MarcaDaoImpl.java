package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Marca;

public class MarcaDaoImpl extends DAOConexao implements MarcaDAO{
    
    @Override
    public void cadastrar(Marca m){
        
        String sql = "INSERT INTO marca (nomeMarca)" + " VALUES ('"+m.getNome()+"');"; 
        
        conectar();
        
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Marca cadastrada com sucesso.","Mensagem do Sistema",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar a marca. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
    }
    
    @Override
    public Marca pesquisar(String nome){
        
        String sql = "SELECT * FROM marca WHERE idMarca = '"+nome+"' OR nomeMarca like '"+nome+"%';";
        
        ResultSet rs;
        
        conectar();
        
        Marca cid = new Marca();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                cid.setCodigo(rs.getInt("idMarca"));
                cid.setNome(rs.getString("nomeMarca"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar a marca. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
        
        return cid;
                
    }
    
    @Override
    public Marca pesquisar(int codigo){
        
        String sql = "SELECT * FROM marca WHERE idMarca = '"+codigo+"';";
        
        ResultSet rs;
        
        conectar();
        
        Marca cid = new Marca();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                cid.setCodigo(rs.getInt("idMarca"));
                cid.setNome(rs.getString("nomeMarca"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar a Marca. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
        
        return cid;
                
    }
    
    @Override
    public int pegarIdMarca(Marca m){
        
        String sql = "SELECT * FROM marca WHERE nomeMarca = '"+m.getNome()+"';";
        
        int id = 0;
        
        ResultSet rs;
        
        conectar();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("idMarca");
                
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao pegar o código da Marca. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
        
        return id;
    }
    
    @Override
    public ArrayList<Marca> selecionarMarcas(){
        
        String sql = "SELECT * FROM marca ORDER BY nomeMarca;";
        
        ResultSet rs;
        
        ArrayList<Marca> marcas = new ArrayList<>();
        
        conectar();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                Marca cid = new Marca();
                cid.setCodigo(rs.getInt("idMarca"));
                cid.setNome(rs.getString("nomeMarca"));
                marcas.add(cid);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao selecionar as marcas. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
        
        return marcas;
    }
   
    @Override
    public void alterar(Marca m){
        
        String sql = "UPDATE marca SET nomeMarca = '"+m.getNome()+"' WHERE idMarca = '"+m.getCodigo()+"';";
        
        conectar();
        
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dados da marca alterados com sucesso.","Mensagem do Sistema",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados da marca. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
    }
    
    @Override
    public void deletar (Marca m){
        
        String sql = "DELETE FROM marca WHERE idMarca = "+m.getCodigo()+";";
        
        conectar();
        
        try{
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Marca deletada com sucesso.","Mensagem do Sistema",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao deletar a Marca. \n Erro:" + ex.getMessage(),"Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
    }

    @Override
    public ArrayList<Marca> selecionarMarcas(String nome) {
        String sql = "SELECT * FROM marca WHERE nomeMarca = '"+nome+"' OR idMarca = '"+nome+"%';";
        
        ResultSet rs;
        
        ArrayList<Marca> marcas = new ArrayList<>();
        
        conectar();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                Marca m = new Marca();
                m.setCodigo(rs.getInt("idMarca"));
                m.setNome(rs.getString("nomeMarca"));
                marcas.add(m);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao selecionar a marca. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
        
        return marcas;
    }

    @Override
    public ResultSet retornarConsultaSQL(String pesq, int opcao) {
        String sql = "";
        ResultSet rs = null;
        
        if (opcao == 1) {
            sql = "SELECT marca.`idMarca` AS cidade_idMarca, marca.`nomeMarca` AS marca_nomeMarca, FROM `marca` marca ORDER BY marca.`nomeMarca` ASC, marca.`nomeMarca` ASC";
        } else if (opcao == 2) {
            sql = "SELECT marca.`idMarca` AS cidade_idMarca, marca.`nomeMarca` AS marca_nomeMarca, FROM `marca` WHERE marca.`nomeMarca` LIKE '%" + pesq + "%'  marca ORDER BY marca.`nomeMarca` ASC";
        }
        
        conectar();
        
        try{
            rs = comando.executeQuery(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar a marca. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        return rs;
    }
    
}
