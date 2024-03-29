/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.daoProduto;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Marca;
import model.Produto;
import model.Tipo;

/**
 *
 * @author PC18
 */
public class TelaCadProduto extends javax.swing.JFrame {
    Date data;
    /**
     * Creates new form TelaEntradaProduto
     */
    
    public TelaCadProduto() {
        initComponents();
        data  = new Date(System.currentTimeMillis());
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        JFTFdataCadastro.setText(formatador.format(data));
        
        litarTipos();
        litarMarcas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTFpesquisa = new javax.swing.JTextField();
        JBpesquisar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTFcodigo = new javax.swing.JTextField();
        JTFnome = new javax.swing.JTextField();
        JTFtipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        JFTFdataCadastro = new javax.swing.JFormattedTextField();
        JTFmarca = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        JTFunidadeCompra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTFpeso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JTFvalorCompra = new javax.swing.JTextField();
        JTFvalorVenda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JTFestoque = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTFdescricao = new javax.swing.JTextArea();
        JTFunidadeVenda = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        JBnovo = new javax.swing.JButton();
        JBsalvar = new javax.swing.JButton();
        JBalterar = new javax.swing.JButton();
        JBexcluir = new javax.swing.JButton();
        JBcancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");

        jLabel1.setText("Pesquisa:");

        JTFpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFpesquisaActionPerformed(evt);
            }
        });

        JBpesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        JBpesquisar.setText("Pesquisar");
        JBpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBpesquisarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        jLabel2.setText("Código:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Marca:");

        JTFcodigo.setEnabled(false);

        JTFnome.setEnabled(false);

        JTFtipo.setEnabled(false);
        JTFtipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JTFtipoItemStateChanged(evt);
            }
        });

        jLabel6.setText("Data do Cadastro:");

        JFTFdataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        JFTFdataCadastro.setEnabled(false);
        JFTFdataCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFTFdataCadastroActionPerformed(evt);
            }
        });

        JTFmarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nike", "Adidas", "Puma" }));
        JTFmarca.setEnabled(false);

        jLabel7.setText("Unidade de Compra");

        JTFunidadeCompra.setEnabled(false);

        jLabel8.setText("Unidade de Venda");

        jLabel9.setText("Peso");

        JTFpeso.setEnabled(false);

        jLabel10.setText("Valor da Compra:");

        JTFvalorCompra.setEnabled(false);

        JTFvalorVenda.setEnabled(false);

        jLabel11.setText("Valor de Venda");

        jLabel12.setText("Estoque Inicial");

        JTFestoque.setEnabled(false);

        jLabel13.setText("Descrição:");

        JTFdescricao.setColumns(20);
        JTFdescricao.setRows(5);
        JTFdescricao.setEnabled(false);
        jScrollPane1.setViewportView(JTFdescricao);

        JTFunidadeVenda.setEnabled(false);
        JTFunidadeVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFunidadeVendaActionPerformed(evt);
            }
        });

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(JTFnome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JTFtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JFTFdataCadastro))
                            .addComponent(JTFmarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JTFvalorCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(JTFunidadeCompra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTFvalorVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(JTFunidadeVenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFpeso))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFestoque, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(JTFcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JFTFdataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(JTFmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JTFunidadeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(JTFpeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFunidadeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(JTFvalorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFvalorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(JTFestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo.png"))); // NOI18N
        JBnovo.setText("Novo");
        JBnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBnovoActionPerformed(evt);
            }
        });

        JBsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gravar.png"))); // NOI18N
        JBsalvar.setText("Salvar");
        JBsalvar.setEnabled(false);
        JBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBsalvarActionPerformed(evt);
            }
        });

        JBalterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar.png"))); // NOI18N
        JBalterar.setText("Alterar");
        JBalterar.setEnabled(false);
        JBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBalterarActionPerformed(evt);
            }
        });

        JBexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        JBexcluir.setText("Excluir");
        JBexcluir.setEnabled(false);
        JBexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBexcluirActionPerformed(evt);
            }
        });

        JBcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        JBcancelar.setText("Cancelar");
        JBcancelar.setEnabled(false);
        JBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFpesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBpesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(JBnovo)
                        .addGap(18, 18, 18)
                        .addComponent(JBsalvar)
                        .addGap(18, 18, 18)
                        .addComponent(JBalterar)
                        .addGap(18, 18, 18)
                        .addComponent(JBexcluir)
                        .addGap(18, 18, 18)
                        .addComponent(JBcancelar)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTFpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBpesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBnovo)
                    .addComponent(JBsalvar)
                    .addComponent(JBalterar)
                    .addComponent(JBexcluir)
                    .addComponent(JBcancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JFTFdataCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFTFdataCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JFTFdataCadastroActionPerformed

    private void JBnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBnovoActionPerformed
        habilitar();
    }//GEN-LAST:event_JBnovoActionPerformed

    public void litarTipos(){
        daoProduto daoTipo = new daoProduto();
        ArrayList<Tipo> tipos = daoTipo.selecionarTipos();
        
        JTFtipo.removeAllItems();
        
        for (Iterator<Tipo> iterator = tipos.iterator(); iterator.hasNext();) {
            Tipo next = iterator.next();
            JTFtipo.addItem(next.getNome());
        }
    }
    
    public void litarMarcas(){
        daoProduto daoMarca = new daoProduto();
        ArrayList<Marca> marcas = daoMarca.selecionarMarca();
        
        JTFmarca.removeAllItems();
        
        for (Iterator<Marca> iterator = marcas.iterator(); iterator.hasNext();) {
            Marca next = iterator.next();
            JTFmarca.addItem(next.getNome());
        }
    }
    
    private void JBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBsalvarActionPerformed
        String nome = JTFnome.getText();
        String tipo = (String) JTFtipo.getSelectedItem();
        String data = JFTFdataCadastro.getText();
        String marca = (String) JTFmarca.getSelectedItem();
        String undCompra = JTFunidadeCompra.getText();
        String undVenda = JTFunidadeVenda.getText();
        int peso = Integer.parseInt(JTFpeso.getText());
        String vlrCompra = ( JTFvalorCompra.getText());
        String vlrVenda = JTFvalorVenda.getText();
        
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setTipo(tipo);
        produto.setUnidCompra(undCompra);
        produto.setUnidVenda(undVenda);
        produto.setPeso(peso);
        produto.setValorCompra(vlrCompra);
        produto.setValorVenda(vlrVenda);
        produto.setDatacad(JFTFdataCadastro.getText());
        produto.setDescricao(JTFdescricao.getText());
        
        daoProduto dao = new daoProduto();
        dao.inserir(produto);
        
    }//GEN-LAST:event_JBsalvarActionPerformed

    private void JTFtipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JTFtipoItemStateChanged
        
    }//GEN-LAST:event_JTFtipoItemStateChanged

    private void JBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcancelarActionPerformed
        resetar();
    }//GEN-LAST:event_JBcancelarActionPerformed

    private void JTFunidadeVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFunidadeVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFunidadeVendaActionPerformed

    private void JTFpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFpesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFpesquisaActionPerformed

    public void habilitar(){
            this.litarTipos();
            this.litarMarcas();
            JTFnome.setEnabled(true);
            JTFtipo.setEnabled(true);
            JFTFdataCadastro.setEnabled(true);
            JTFnome.setEnabled(true);
            JTFmarca.setEnabled(true);
            JTFunidadeCompra.setEnabled(true);
            JTFunidadeVenda.setEnabled(true);
            JTFvalorVenda.setEnabled(true);
            JTFpeso.setEnabled(true);
            JTFvalorCompra.setEnabled(true);
            JTFvalorVenda.setEnabled(true);
            JTFestoque.setEnabled(true);
            JTFdescricao.setEnabled(true);
            JTFpesquisa.setEnabled(false);
            JBnovo.setEnabled(false);
            JBsalvar.setEnabled(true);
            JBcancelar.setEnabled(true);
            JBpesquisar.setEnabled(false);
    }
    private void JBpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBpesquisarActionPerformed
        String pesquisa = JTFpesquisa.getText();
        Produto pro;
        daoProduto daopro = new daoProduto();
        pro = daopro.pesquisar(pesquisa);
        if(pro.getCodigo() == 0){
            JOptionPane.showMessageDialog(null, "Produto não encontrada", "Cadastro Produto", 0);
        }else{
            habilitar();
            
            JTFcodigo.setText(Integer.toString(pro.getCodigo()));
            JTFnome.setText(pro.getNome());
            JTFtipo.setSelectedItem(pro.getTipo());
            JFTFdataCadastro.setText(pro.getDatacad());
            JTFmarca.setSelectedItem(pro.getMarca());
            JTFunidadeCompra.setText(pro.getUnidCompra());
            JTFunidadeVenda.setText(pro.getUnidVenda());
            JTFpeso.setText(Integer.toString(pro.getPeso()));
            JTFvalorCompra.setText(pro.getValorCompra());
            JTFvalorVenda.setText(pro.getValorVenda());
            JTFestoque.setText(Integer.toString(pro.getEstoqueAtual()));
            JTFdescricao.setText(pro.getDescricao());            
        }
        JTFpesquisa.setEnabled(true);
        JBpesquisar.setEnabled(true);
        JBsalvar.setEnabled(false);
        JBalterar.setEnabled(true);
        JBexcluir.setEnabled(true);
        JBcancelar.setEnabled(true);
    }//GEN-LAST:event_JBpesquisarActionPerformed

    private void JBexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBexcluirActionPerformed
        daoProduto daopro = new daoProduto();
        Produto produto = new Produto();
        
        int codigo = Integer.parseInt(JTFcodigo.getText());
        produto.setCodigo(codigo);
    }//GEN-LAST:event_JBexcluirActionPerformed

    private void JBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBalterarActionPerformed
        String nome = JTFnome.getText();
        String tipo =  (String) JTFtipo.getSelectedItem();
        String data = JFTFdataCadastro.getText();
        String marca = (String) JTFmarca.getSelectedItem();
        String undCompra = JTFunidadeCompra.getText();
        String undVenda = JTFunidadeVenda.getText();
        int peso = Integer.parseInt(JTFpeso.getText());
        String vlrCompra = ( JTFvalorCompra.getText());
        String vlrVenda = JTFvalorVenda.getText();
        
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setTipo(tipo);
        produto.setUnidCompra(undCompra);
        produto.setUnidVenda(undVenda);
        produto.setPeso(peso);
        produto.setValorCompra(vlrCompra);
        produto.setValorVenda(vlrVenda);
        
        daoProduto daopro = new daoProduto();
        daopro.alterar(produto);
    }//GEN-LAST:event_JBalterarActionPerformed

    public void resetar(){
        JTFpesquisa.setText("");
        JTFcodigo.setText("");
        JTFnome.setText("");
        JFTFdataCadastro.setText("");
        JTFunidadeCompra.setText("");
        JTFunidadeVenda.setText("");
        JTFvalorVenda.setText("");
        JTFpeso.setText("");
        JTFvalorCompra.setText("");
        JTFvalorVenda.setText("");
        JTFestoque.setText("");
        JTFdescricao.setText("");
        JTFpesquisa.setEnabled(true);
        JTFcodigo.setEnabled(false);
        JTFnome.setEnabled(false);
        JTFtipo.setEnabled(false);
        JFTFdataCadastro.setEnabled(false);
        JTFmarca.setEnabled(false);
        JTFunidadeCompra.setEnabled(false);
        JTFunidadeVenda.setEnabled(false);
        JTFvalorVenda.setEnabled(false);
        JTFpeso.setEnabled(false);
        JTFvalorCompra.setEnabled(false);
        JTFvalorVenda.setEnabled(false);
        JTFestoque.setEnabled(false);
        JTFdescricao.setEnabled(false);
        JTFtipo.removeAllItems();
        JTFmarca.removeAllItems();
        JBnovo.setEnabled(true);
        JBsalvar.setEnabled(false);
        JBalterar.setEnabled(false);
        JBexcluir.setEnabled(false);
        JBcancelar.setEnabled(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBalterar;
    private javax.swing.JButton JBcancelar;
    private javax.swing.JButton JBexcluir;
    private javax.swing.JButton JBnovo;
    private javax.swing.JButton JBpesquisar;
    private javax.swing.JButton JBsalvar;
    private javax.swing.JFormattedTextField JFTFdataCadastro;
    private javax.swing.JTextField JTFcodigo;
    private javax.swing.JTextArea JTFdescricao;
    private javax.swing.JTextField JTFestoque;
    private javax.swing.JComboBox<String> JTFmarca;
    private javax.swing.JTextField JTFnome;
    private javax.swing.JTextField JTFpeso;
    private javax.swing.JTextField JTFpesquisa;
    private javax.swing.JComboBox<String> JTFtipo;
    private javax.swing.JTextField JTFunidadeCompra;
    private javax.swing.JTextField JTFunidadeVenda;
    private javax.swing.JTextField JTFvalorCompra;
    private javax.swing.JTextField JTFvalorVenda;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
