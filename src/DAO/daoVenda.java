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

public class daoVenda extends DAOConexao {

    public void inserir(Venda venda) {
        int codigoProduto = venda.getCodigoProduto();
        int codigoCliente = venda.getCodigoCliente();
        String data = venda.getData();
        double valorTotal = venda.getValorTotal();
        int quantidade = venda.getQuantidade();
        double desconto = venda.getDesconto();
        String formaPg = venda.getFormaPagamento();
        
        String sql = "INSERT INTO venda (idClienteVenda, dataVenda,valorTotalVenda, descontoVenda ,tipoPagamentoVenda , idProdutoVenda , quantidadeProdutoVenda) VALUES ('" + codigoCliente + "','" + data + "','" + valorTotal + "' , '" + desconto + "', '" + formaPg + "' , '" + codigoProduto + "', '" + quantidade + "');";
        System.out.println(sql);
        conectar();
        try {
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sucesso ao efetuar a venda", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a venda \n Erro:" + ex.getMessage(), "Erro do sistema", JOptionPane.ERROR_MESSAGE);
        }
        fechar();
    }
       
}
