package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioDAO extends DAOConexao {

    public void cadastrar(Usuario usuario) {
        String nome = usuario.getNome();
        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        String sql = "INSERT INTO usuario (nomeUsuario, emailUsuario, senhaUsuario)" + " VALUES ('" + nome + "','" + email + "','" + senha + "');";

        conectar();

        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir os dados do Usuario", "Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados do Usuario\n Erro:" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }

        fechar();
    }

    public Usuario pesquisar(String nome) {
        conectar();
        String sql = "SELECT * FROM usuario WHERE nomeUsuario = '" + nome + "';";
        ResultSet rs;
        Usuario usuario = new Usuario();
        try {
            rs = comando.executeQuery(sql);
            while (rs.next()) {
                usuario.setCodigo(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nomeUsuario"));
                usuario.setEmail(rs.getString("emailUsuario"));
                usuario.setSenha(rs.getString("senhaUsuario"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return usuario;
    }
    
    public Usuario pesquisar(int codigo) {
        conectar();
        String sql = "SELECT * FROM usuario WHERE idUsuario = '" + codigo + "';";
        ResultSet rs;
        Usuario usuario = new Usuario();
        try {
            rs = comando.executeQuery(sql);
            while (rs.next()) {
                usuario.setCodigo(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nomeUsuario"));
                usuario.setEmail(rs.getString("emailUsuario"));
                usuario.setSenha(rs.getString("senhaUsuario"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return usuario;
    }

    public void alterar(Usuario usuario) {
        conectar();
        String nome = usuario.getNome();
        String email = usuario.getEmail();
        String senha = usuario.getSenha();
        int codigo = usuario.getCodigo();

        String sql = "UPDATE usuario SET nomeUsuario = '" + nome + "',emailUsuario = '" + email + "', senhaUsuario = '" + senha + "' WHERE idUsuario = '" + codigo + "';";

        conectar();

        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso ao alterar os dados do Usuario", "Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados do Usuario\n Erro:" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }

        fechar();
    }

    public void deletar(Usuario uso) {
        int codigo = uso.getCodigo();
        String sql = "DELETE FROM usuario WHERE idUsuario = " + codigo + ";";
        conectar();
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario deletada com Sucesso!", "Mensagem do Sistema", 0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o Usuario. Erro:" + ex.getMessage(), "Erro do Sistema", 0);
        }
    }
    
    public boolean validar(String senha, String email){
        String sql = "SELECT * FROM usuario WHERE emailUsuario = '"+email+"' AND senhaUsuario ='"+senha+"'";
        
        conectar();
        ResultSet rs;
        int codigo = 0;
        try {
            rs = comando.executeQuery(sql);
            while (rs.next()){
                codigo = rs.getInt("idUsuario");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao validadar o usuário");
        }
        if (codigo == 0){
            return false;
        } else {
            return true;
        }
    }
    
    public ArrayList<Usuario> selecionarUsuarios(){
        
        String sql = "SELECT * FROM cidade ORDER BY nomeCidade;";
        
        ResultSet rs;
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        conectar();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                Usuario user = new Usuario();
                user.setCodigo(rs.getInt("idUsuario"));
                user.setNome(rs.getString("nomeUsuario"));
                user.setEmail(rs.getString("emailUsuario"));
                user.setSenha(rs.getString("senhaUsuario"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os usuários. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
        
        return usuarios;
    }
    
    public ArrayList<Usuario> pesquisarUsuarios(String nome ){
        
        String sql = "SELECT * FROM cidade WHERE nomeUsuario LIKE '"+nome+"%'ORDER BY nomeUsuario;";
        
        ResultSet rs;
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        conectar();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                Usuario user = new Usuario();
                user.setCodigo(rs.getInt("idUsuario"));
                user.setNome(rs.getString("nomeUsuario"));
                user.setEmail(rs.getString("emailUsuario"));
                user.setSenha(rs.getString("senhaUsuario"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os usuários. \n Erro:" + ex.getMessage(),"Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
        
        return usuarios;
    }
    
}
