package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Cidade;
import model.Cliente;


public class DAOCliente extends DAOConexao{
   public void inserir(Cliente cliente){
        String nome = cliente.getNome();
        String rg = cliente.getRg();
        String cpf = cliente.getCpf();
        String email = cliente.getEmail();
        String sexo = cliente.getSexo();
        String dataNasc = cliente.getDataNasc();
        String telefone = cliente.getTelefone();
        String celular = cliente.getCelular();
        String rua = cliente.getRua();
        String bairro = cliente.getBairro();
        int numero = cliente.getNum();
        String cep = cliente.getCep();
        String uf = cliente.getUf();
        String cidade = cliente.getCidade();
        
        CidadeDaoImpl daoCid = new CidadeDaoImpl();
        int idCidade = 0;//daoCid.pegarIdCidade(cidade, uf);
        
        String referencia = cliente.getReferencia();
        
        String sql = "INSERT INTO cliente (nomeCliente, rgCliente, cpfCliente, emailCliente, sexoCliente, dataNascCliente, telefoneCliente, celularCliente, ruaCliente, bairroCliente, numCliente, cepCliente, referenciaCliente, idCidadeCliente)" + " VALUES ('"+nome+"','"+rg+"','"+cpf+"','"+email+"','"+sexo+"','"+dataNasc+"','"+telefone+"','"+celular+"','"+rua+"','"+bairro+"','"+numero+"','"+cep+"','"+referencia+"','"+idCidade+"');"; 
        conectar();
        
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir os dados do Cliente","Mensagem do Sistema",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados do Cliente\n Erro:" + ex.getMessage() ,"Erro do Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
    }
    public Cliente pesquisar(String nome){
        conectar();
        String sql = "SELECT * FROM cliente WHERE idCliente = '"+nome+"' OR nomeCliente like '"+nome+"';";
        ResultSet rs;
        Cliente cli = new Cliente();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                cli.setCodigo(rs.getInt("idCliente"));
                cli.setNome(rs.getString("nomeCliente"));
                cli.setRg(rs.getString("rgCliente"));
                cli.setCpf(rs.getString("cpfCliente"));
                cli.setEmail(rs.getString("emailCliente"));
                cli.setSexo(rs.getString("sexoCliente"));
                cli.setDataNasc(rs.getString("dataNascCliente"));
                cli.setTelefone(rs.getString("telefoneCliente"));
                cli.setCelular(rs.getString("celularCliente"));
                cli.setRua(rs.getString("ruaCliente"));
                cli.setBairro(rs.getString("bairroCliente"));
                cli.setNum(rs.getInt("numCliente"));
                cli.setCep(rs.getString("cepCliente"));
                cli.setCodigoCidade(rs.getInt("idCidadeCliente"));
                cli.setReferencia(rs.getString("referenciaCliente"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cli;
    }
    
    public void atualizar(Cliente cliente){
        int codigo = cliente.getCodigo();
        String nome = cliente.getNome();
        String rg = cliente.getRg();
        String cpf = cliente.getCpf();
        String email = cliente.getEmail();
        String sexo = cliente.getSexo();
        String dataNasc = cliente.getDataNasc();
        String telefone = cliente.getTelefone();
        String celular = cliente.getCelular();
        String rua = cliente.getRua();
        String bairro = cliente.getBairro();
        int numero = cliente.getNum();
        String cep = cliente.getCep();
        String uf = cliente.getUf();
        String cidade = cliente.getCidade();
        
        String sql = "UPDATE cliente SET "
                + "nomeCliente = '"+nome+"',"
                + "rgCliente = '"+rg+"',"
                + " emailCliente = '"+email+"',"
                + " sexoCliente = '"+sexo+"',"
                + " dataNascCliente = '"+dataNasc+"',"
                + " telefoneCliente = '"+telefone+"',"
                + " celularCliente = '"+celular+"',"
                + " ruaCliente = '"+rua+"',"
                + " bairroCliente = '"+bairro+"',"
                + " numCliente = '"+numero+"',"
                + " WHERE idCliente = '"+codigo+"';";
        
        conectar();
        
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Mensagem do Sistema","Sucesso ao alterar os dados da Cidade",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro do Sistema","Erro ao alterar os dados da Cidade\n Erro:" + ex.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        fechar();
    }
    
    public void deletar (Cliente cli){
        int codigo = cli.getCodigo();
        String sql = "DELETE FROM Cliente WHERE idCliente= "+codigo+";";
        conectar();
        try{
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cliente deletado com Sucesso!","Mensagem do Sistema",0);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao deletar o cliente. Erro:"+ex.getMessage(), "Erro do Sistema",0);
        }
    }
    
}
