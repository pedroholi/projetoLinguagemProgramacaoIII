package DAO;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAOConexao {
    /**
     * Declaração de variaveis
     */
    protected Connection con;
    protected Statement comando;
    /**
     * Método responsável pelo conectar com o banco de dados
     */
    protected void conectar() {
        try {
            con = (Connection) ConFactory.conexao(ConFactory.MYSQL);
            comando = (Statement) con.createStatement();
            this.setCon(con);
        } catch (ClassNotFoundException e){
            imprimeErro("Erro ao carregar o driver",e.getMessage());
        } catch (SQLException e) {
            imprimeErro("Erro ao conectar",e.getMessage());
        }
    }
     /**
     * Método responsável por fechar a conexão com o banco de dados
     */
    protected void fechar() {
        try {
            comando.close();
            con.close();
        } catch (SQLException e) {
            imprimeErro("Erro ao fechar conexão",e.getMessage());
        }
    }
    /**
     * Método responsável por imprimir possiveis erros que poderam acontecer na
     * realização de operações com o banco de dados
     * @param msg
     * @param msgErro
     */
    protected void imprimeErro(String msg, String msgErro) {
        JOptionPane.showMessageDialog(null, msg + " \nErro: " + msgErro, "Erro crítico", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getComando() {
        return comando;
    }

    public void setComando(Statement comando) {
        this.comando = comando;
    }
    
    
    
}

