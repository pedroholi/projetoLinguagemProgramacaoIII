package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Marca;
import model.Produto;
import model.Tipo;
import model.Venda;

public class daoProduto extends DAOConexao {

    public void inserir(Produto produto) {
        int codigo = produto.getCodigo();
        String nome = produto.getNome();
        String datacad = produto.getDatacad();
        String unidCompra = produto.getUnidCompra();
        String unidVenda = produto.getUnidVenda();
        double peso = produto.getPeso();
        String valorVenda = produto.getValorVenda();
        String valorCompra = produto.getValorCompra();
        String descricao = produto.getDescricao();
        int tipo = this.pegarCodTipo(produto.getTipo());
        int codigoMarca = this.pegarCodMarca(produto.getMarca());
        

        String sql = "INSERT INTO produto (nomeProduto, dataCadProduto,unidCompraProduto, unidVendaProduto ,pesoProduto , valorVendaProduto , descricaoProduto, idTipoProduto ,idMarcaProduto, valorCompraProduto ) VALUES ('" + nome + "','" + datacad + "','" + unidCompra + "' , '" + unidVenda + "', '" + 1 + "' , '" + valorVenda + "', '" + descricao + "' , '" + tipo + "', '" + codigoMarca + "', '" + valorCompra + "');";
        System.out.println(sql);
        conectar();
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir dados do produto ", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados do produto \n Erro:" + ex.getMessage(), "Erro do sistema", JOptionPane.ERROR_MESSAGE);
        }
        fechar();
    }
    
    public Produto pesquisar(String nome){
        conectar();
        String sql = "SELECT * FROM produto WHERE idProduto = '"+nome+"' OR nomeProduto = '"+nome+"';";
        ResultSet rs;
        
        Produto pro = new Produto();
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                pro.setCodigo(rs.getInt("idProduto"));
                pro.setNome(rs.getString("nomeProduto"));
                pro.setDatacad(rs.getString("dataCadProduto"));
                pro.setUnidCompra(rs.getString("unidCompraProduto"));
                pro.setUnidVenda(rs.getString("unidVendaProduto"));
                pro.setPeso(rs.getInt("pesoProduto"));
                pro.setValorVenda(rs.getString("valorVendaProduto"));
                pro.setValorCompra(rs.getString("valorCompraProduto"));
                pro.setDescricao(rs.getString("descricaoProduto"));
                pro.setTipo(rs.getString("idTipoProduto"));
                pro.setMarca(rs.getString("idmarcaProduto"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return pro;
    }
    
    public Cliente pesquisarCliente(String nome){
        String sql = "SELECT idCliente, nomeCliente, cpfCliente, rgCliente FROM cliente WHERE idCliente = '"+nome+"' OR nomeCliente like '"+nome+"';";
        ResultSet rs;
        Cliente cli = new Cliente();
        
        conectar();
        
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                System.out.println(sql);
                cli.setCodigo(rs.getInt("idCliente"));
                cli.setNome(rs.getString("nomeCliente"));
                cli.setRg(rs.getString("rgCliente"));
                cli.setCpf(rs.getString("cpfCliente"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cli;
    }

    public void entradaEstoque(int codigo, String data, int quantidade) {

        String sql = "INSERT INTO entrada (idProdutoEntrada, quantEntrada,dataEntrada) VALUES ('" + codigo + "','" + quantidade + "','" + data + "' );";

        conectar();
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso ao atualizar o estoque ", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o estoque \n Erro:" + ex.getMessage(), "Erro do sistema", JOptionPane.ERROR_MESSAGE);
        }
        fechar();
    }

    public Produto pesquisarProduto(String nome) {
        conectar();
        String sql = "SELECT *FROM produto WHERE idProduto = '" + nome + "' OR nomeProduto = '" + nome + "'";
        ResultSet rs;
        Produto produto = new Produto();
        try {
            rs = comando.executeQuery(sql);
            while (rs.next()) {
                produto.setCodigo(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nomeProduto"));
                produto.setDatacad(rs.getString("dataCadProduto"));
                produto.setUnidCompra(rs.getString("unidCompraProduto"));
                produto.setUnidVenda(rs.getString("unidVendaProduto"));
                produto.setPeso(rs.getInt("pesoProduto"));
                produto.setValorVenda(rs.getString("valorVendaProduto"));
                produto.setDescricao(rs.getString("descricaoProduto"));
                produto.setTipo(rs.getString("idTipoProduto"));
                produto.setMarca(rs.getString("idmarcaProduto"));
                produto.setEstoqueAtual(rs.getInt("idmarcaProduto"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(sql);
        }
        return produto;
    }

    public void deletar(Produto produto) {
        int codigo = produto.getCodigo();
        String sql = "DELETE FROM produto WHERE idProduto = " + codigo + ";";
        conectar();
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario deletada com sucesso!", "Mensagem do Sistema", 0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar usuario. Erro:" + ex.getMessage(), "Erro do Sistema", 0);
        }
    }

    public void alterar(Produto produto) {
        int codigo = produto.getCodigo();
        String nome = produto.getNome();
        String datacad = produto.getDatacad();
        String unidCompra = produto.getUnidCompra();
        String unidVenda = produto.getUnidVenda();
        double peso = produto.getPeso();
        String valorVenda = produto.getValorVenda();
        String valorCompra = produto.getValorCompra();
        String descricao = produto.getDescricao();
        int tipo = this.pegarCodTipo(produto.getTipo());
        int codigoMarca = this.pegarCodMarca(produto.getMarca());

        String sql = "UPDATE produto SET nomeProduto = '" + nome + "', dataCadProduto = '" + datacad + "', unidCompraProduto = '" + unidCompra + "', unidVendaProduto = '" + unidVenda + "' , pesoProduto = '" + peso + "', valorVendaProduto = '" + valorVenda + "', valorCompraProduto = '" + valorCompra + "', descricaoProduto = '" + descricao + "', idTipoProduto = '" + tipo + "' , idMarcaProduto = '" + codigoMarca + "' WHERE idProduto = " + codigo + ";";

        conectar();
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso ao alterar dados do produto ", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados do produto \n Erro:" + ex.getMessage(), "Erro do sistema", JOptionPane.ERROR_MESSAGE);
        }
        fechar();
    }

    public int pegarQuantidadeProduto(int codigo) {
        int quantidade = 0;
        String sql = "SELECT SUM(quantEntrada) as quantidade FROM entrada WHERE idProdutoEntrada = '" + codigo + "'";

        conectar();

        ResultSet rs;
        Produto produto = new Produto();
        try {
            rs = comando.executeQuery(sql);
            while (rs.next()) {
                quantidade = rs.getInt("quantidade");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        fechar();
        return quantidade;
    }
    
    public ArrayList<Tipo> selecionarTipos(){
        conectar();
        String sql = "SELECT * FROM tipo;";
        ResultSet rs;
        
        ArrayList<Tipo> tipos = new ArrayList<>();
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                Tipo tipo = new Tipo();
                tipo.setCodigo(rs.getInt("idTipo"));
                tipo.setNome(rs.getString("nomeTipo"));
                tipos.add(tipo);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return tipos;
    }
    
    public ArrayList<Marca> selecionarMarca(){
        conectar();
        String sql = "SELECT * FROM marca;";
        ResultSet rs;
        
        ArrayList<Marca> marcas = new ArrayList<>();
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                Marca marca = new Marca();
                marca.setCodigo(rs.getInt("idMarca"));
                marca.setNome(rs.getString("nomeMarca"));
                marcas.add(marca);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return marcas;
    }
    
    public String pegarMarca(int marca){
        String sql = "SELECT * FROM marca WHERE idMarca = "+ marca;
        ResultSet rs;
        System.out.println("asdasdsdasdsadadsad");
        String m = "";
        conectar();
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                m = rs.getString("nomeMarca");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return m;
    }
    
    public int pegarCodTipo(String tipo){
        String sql = "SELECT * FROM tipo WHERE nomeTipo = '"+tipo+"'";
        ResultSet rs;
        int codigo = 0;
        conectar();
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                codigo = rs.getInt("idTipo");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return codigo;
    }
    
    public int pegarCodMarca(String tipo){
        String sql = "SELECT * FROM marca WHERE nomeMarca = '"+tipo+"'";
        ResultSet rs;
        int codigo = 0;
        conectar();
        try{
            rs = comando.executeQuery(sql);
            while(rs.next()){
                codigo = rs.getInt("idMarca");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return codigo;
    }
    
    
}
