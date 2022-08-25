/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import biblioteca.*;
import java.awt.Color;
import java.time.Clock;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karll
 */
public class JFPeriodico extends javax.swing.JFrame {

    private TelaPrincipal telaPrincipal;
    private Biblioteca biblioteca;
    private Periodico periodico;
    private boolean alteracao;
    
    DefaultTableModel tmPeriodico = new DefaultTableModel(null, new String[]{"Nome", "Editora", "Volume", "Data Publicação"});
    
    /**
     * Creates new form JFPeriodico
     */
    public JFPeriodico() {
        initComponents();
    }
    
    public JFPeriodico(TelaPrincipal telaPrincipal, Biblioteca b) {
        this();
        
        this.telaPrincipal = telaPrincipal;
        this.biblioteca = b;
        this.alteracao = false;
        
        jBAlterar.setEnabled(false);
        jBExcluir.setEnabled(false);
        jBSalvar.setEnabled(false);
        
        desabilitaCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jBPesquisar = new javax.swing.JButton();
        jTFPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTFVolume = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTFEditora = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFNumero = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFDataPub = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jBNovo = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFStatusEmp = new javax.swing.JTextField();
        jTFStatusRes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Periódicos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Periódico"));

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jTFPesquisa.setName("jTFPesquisa"); // NOI18N
        jTFPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPesquisaActionPerformed(evt);
            }
        });

        jLabel1.setText("Título:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTable1.setModel(tmPeriodico);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Periódico"));

        jLabel7.setText("Título:");

        jLabel9.setText("Volume:");

        jTFVolume.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFVolumeKeyTyped(evt);
            }
        });

        jLabel10.setText("Editora:");

        jLabel11.setText("Número:");

        jTFNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNumeroKeyTyped(evt);
            }
        });

        jLabel12.setText("Data Publicação:");

        jTFDataPub.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jTFDataPub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDataPubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(jTFEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jTFDataPub, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(36, 36, 36)
                        .addComponent(jTFNome)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTFVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jTFEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTFDataPub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Situação:");

        jTFStatusEmp.setEditable(false);
        jTFStatusEmp.setBorder(null);
        jTFStatusEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFStatusEmpActionPerformed(evt);
            }
        });

        jTFStatusRes.setEditable(false);
        jTFStatusRes.setBorder(null);
        jTFStatusRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFStatusResActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFStatusRes, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFStatusEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFStatusEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTFStatusRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed

        jBSalvar.setEnabled(false);
        jBAlterar.setEnabled(false);
        jBExcluir.setEnabled(false);
        jBNovo.setEnabled(true);
        limpaCampos();
        desabilitaCampos();
        limparSituacao();

        ArrayList<Periodico> periodico = new ArrayList<>();

        String texto = jTFPesquisa.getText();

        if(texto.equals("")){
            JOptionPane.showMessageDialog(null, "Digite o nome do Periódico!", "Error", JOptionPane.ERROR_MESSAGE);
            limpaCampos();
        } else {
            
            periodico = biblioteca.listarPeriodicosNome(texto);
            
            if(periodico.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
                limpaCampos();
            } else {
                limparTabela();
                String[] linha = new String[] {null, null, null, null};
                // P/ cada registro é criada uma nova linha, cada linha recebe os campos do registro
                for (int i = 0; i < periodico.size(); i++) {
                    tmPeriodico.addRow(linha);
                    tmPeriodico.setValueAt(periodico.get(i).getTitulo(), i, 0);
                    tmPeriodico.setValueAt(periodico.get(i).getEditora(), i, 1);
                    tmPeriodico.setValueAt(periodico.get(i).getVolume(), i, 2);
                    tmPeriodico.setValueAt(periodico.get(i).getDataPublicacao(), i, 3);
                }
            }

        }

        jTFPesquisa.setText("");
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jTFPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPesquisaActionPerformed
        // TODO add your handling code here:
        System.out.println("CLicou!!!");
    }//GEN-LAST:event_jTFPesquisaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = jTable1.getSelectedRow();
        desabilitaCampos();

        try{
            //procurando pelo objeto com nome exato
            periodico = (Periodico) biblioteca.procurarItem((String)jTable1.getValueAt(linhaSelecionada, 0));

            jTFNumero.setText("" + periodico.getNumero());
            jTFEditora.setText(periodico.getEditora());
            jTFVolume.setText(""+periodico.getVolume());
            jTFNome.setText(periodico.getTitulo());
            jTFDataPub.setText("" + periodico.getDataPublicacao());

            if(periodico.isReservado()){
                jTFStatusRes.setText("Periódico reservado!");
            } else {
                jTFStatusRes.setText("Não possui reservas!");
            }

            if(periodico.isDisponivel()){
                jTFStatusEmp.setText("DISPONÍVEL");
                jTFStatusEmp.setForeground(Color.GREEN);
            } else {
                jTFStatusEmp.setText("INDISPONÍVEL");
                jTFStatusEmp.setForeground(Color.red);
            }

            jBAlterar.setEnabled(true);
            jBExcluir.setEnabled(true);

        } catch (BuscaFalhouException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
            limpaCampos();
            limparSituacao();
            jBAlterar.setEnabled(false);
            jBExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        // TODO add your handling code here:
        limparTabela();
        limpaCampos();
        habilitaCampos();
        limparSituacao();
        jBNovo.setEnabled(false);
        jBAlterar.setEnabled(false);
        jBExcluir.setEnabled(false);
        jBSalvar.setEnabled(true);
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        // TODO add your handling code here:

        habilitaCampos();
        jBSalvar.setEnabled(true);
        jBNovo.setEnabled(false);
        jBExcluir.setEnabled(false);
        this.alteracao = true;
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        // TODO add your handling code here:
        
        int resp = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este registro?",
            "Confirmação!", JOptionPane.YES_NO_OPTION);

        //se for sim
        if(resp == JOptionPane.YES_NO_OPTION){

            biblioteca.getItens().remove(periodico);

            limpaCampos();
            desabilitaCampos();
            jBExcluir.setEnabled(false);
            jBAlterar.setEnabled(false);
            limparSituacao();
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        // TODO add your handling code here:
        String titulo = jTFNome.getText();
        String numeroString = jTFNumero.getText();
        String dataPubli = jTFDataPub.getText();
        String editora = jTFEditora.getText();
        String volumeString = jTFVolume.getText();
        
        if(titulo.isBlank()||numeroString.isBlank()||dataPubli.isBlank()||editora.isBlank()||
                volumeString.isBlank()) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int numero = Integer.parseInt(numeroString);
        int volume = Integer.parseInt(volumeString);

        if(alteracao){

            periodico.setNumero(numero);
            periodico.setEditora(editora);
            periodico.setVolume(volume);
            periodico.setDataPublicacao(dataPubli);
            periodico.setTitulo(titulo);

            this.alteracao = false;

            JOptionPane.showMessageDialog(null, "Periódico alterado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Periodico p = new Periodico(titulo, editora, volume, numero, dataPubli);
            biblioteca.addItens(p);
            JOptionPane.showMessageDialog(null, "Periódico incluido com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

        jBNovo.setEnabled(true);
        jBExcluir.setEnabled(true);
        jBAlterar.setEnabled(true);
        jBSalvar.setEnabled(false);
        desabilitaCampos();
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jTFStatusEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFStatusEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFStatusEmpActionPerformed

    private void jTFStatusResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFStatusResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFStatusResActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
        telaPrincipal.setEnabled(true);
        telaPrincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jTFNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNumeroKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_jTFNumeroKeyTyped

    private void jTFVolumeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFVolumeKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_jTFVolumeKeyTyped

    private void jTFDataPubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDataPubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDataPubActionPerformed

    private void desabilitaCampos(){
        jTFNumero.setEditable(false);
        jTFEditora.setEditable(false);
        jTFVolume.setEditable(false);
        jTFNome.setEditable(false);
        jTFDataPub.setEditable(false);
    }
    
    private void habilitaCampos(){
        jTFNumero.setEditable(true);
        jTFEditora.setEditable(true);
        jTFVolume.setEditable(true);
        jTFNome.setEditable(true);
        jTFDataPub.setEditable(true);
    }
    
    private void limpaCampos(){
        jTFNumero.setText("");
        jTFEditora.setText("");
        jTFVolume.setText("");
        jTFNome.setText("");
        jTFDataPub.setText("");
    }
    
    // Limpa a tabela de resultados
    private void limparTabela() {       
        while (tmPeriodico.getRowCount() > 0) {            
            tmPeriodico.removeRow(0);
        }
    }
    
    private void limparSituacao(){
        jTFStatusEmp.setText("");
        jTFStatusRes.setText("");
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
            java.util.logging.Logger.getLogger(JFPeriodico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPeriodico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPeriodico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPeriodico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPeriodico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jTFDataPub;
    private javax.swing.JTextField jTFEditora;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTextField jTFStatusEmp;
    private javax.swing.JTextField jTFStatusRes;
    private javax.swing.JTextField jTFVolume;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
