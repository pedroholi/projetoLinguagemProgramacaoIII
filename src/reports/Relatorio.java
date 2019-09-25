/*
 * Nome: Classe Emissão de Relatórios
 * Versão: 1.0
 * Descrição: Classe responsável pela emissão de relatórios
 * Entradas:  Opção de Pesquisa, parâmetro de pesquisa
 * Saídas: Relatório impresso 
 * Efeitos Colaterais: 
 * Su-rotinas Chamadas: 
 * Casos não tratados: Relatório de outras funcionalidades do sistema
 * Pendências: 
 * Exemplo de Uso: 
 * Autor(es): Pedro Henrique de Oliveira e Silva
 */
package reports;

import DAO.DAOConexao;
import controller.CidadeController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio extends DAOConexao {
    
    CidadeController controllerCid;
    
    public void emitirRelatorioCidades(String pesq, int opcao) {
     
        controllerCid = new CidadeController();
        
        String reportSource = "/Users/pedrohenrique/Documents/Projeto/src/reports/cidades.jrxml";
        String reportSourceJasper = "/Users/pedrohenrique/Documents/Projeto/src/reports/cidades.jasper";
        String reportSourcePrint = "/Users/pedrohenrique/Documents/Projeto/src/reports/cidades.jrprint";
        
        try {

            JasperCompileManager.compileReportToFile(reportSource);
            Map<String, Object> params = new HashMap<String, Object>();
            JRResultSetDataSource jrRS = new JRResultSetDataSource(controllerCid.retornarConsultaSQL(pesq, opcao));
            JasperFillManager.fillReportToFile(reportSourceJasper, params, jrRS);
            JasperViewer.viewReport(reportSourcePrint, false, false);

        } catch (JRException ex) {
            imprimeErro("Erro ao emitir o relatório de Cidades", ex.getMessage());
        }
        
    }
}
