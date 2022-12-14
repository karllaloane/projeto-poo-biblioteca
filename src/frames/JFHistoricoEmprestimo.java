/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import biblioteca.*;
import controle.SortByData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karlla
 */
public class JFHistoricoEmprestimo extends javax.swing.JFrame {

    private TelaPrincipal telaPrincipal;
    private Biblioteca biblioteca;
    
    DefaultTableModel tmLista = new DefaultTableModel(null, new String[]{"Livro", "Cliente", "Data Empréstimo", "Entrega Prevista", "Devolvido em", "Situação", "Multa"});
    
    /**
     * Creates new form JFHistoricoEmprestimo
     */
    public JFHistoricoEmprestimo() {
        initComponents();
    }

    public JFHistoricoEmprestimo(TelaPrincipal telaPrincipal, Biblioteca b) {
        this();
        
        this.telaPrincipal = telaPrincipal;
        this.biblioteca = b;
        
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();        
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
       
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        
        //jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(180);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
        
        ArrayList<Emprestimo> emp = biblioteca.buscTodosEmprestimos();
        listarEmprestimos(emp);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Empréstimos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(tmLista);
        jTable1.setEnabled(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel1.setText("Historico de Empréstimos");

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Em aberto", "Com multa" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtrar:");

        jLabel3.setText("* Com multa não paga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
        JComboBox<String> combo = (JComboBox<String>) evt.getSource();
        
        String selected = (String) combo.getSelectedItem();
        
         if (selected.equals("Todos")) {
            ArrayList<Emprestimo> emp = biblioteca.buscTodosEmprestimos(); 
            listarEmprestimos(emp);
        } else if (selected.equals("Em aberto")) {
            ArrayList<Emprestimo> emp = biblioteca.buscaEmprestimosEmAberto(); 
            listarEmprestimos(emp);
        } else if (selected.equals("Com multa")) {
            ArrayList<Emprestimo> emp = biblioteca.buscTodosEmprestimos(); 
            listarEmprestimosComMulta(emp);
        }
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        telaPrincipal.setEnabled(true);
        telaPrincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    public void listarEmprestimos(ArrayList<Emprestimo> emp){
        limparTabela();
        
        
        ArrayList<Emprestimo> lista = new ArrayList<Emprestimo>(emp);        
        Collections.sort(lista, new SortByData());
        
        //ArrayList<Emprestimo> lista = emp;
        String[] linha = new String[] {null, null, null, null, null, null, null};
           
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (int i = 0; i < lista.size(); i++) {
            tmLista.addRow(linha);
            //tmLista.setValueAt(emp.get(i).getID(), i, 0);
            tmLista.setValueAt(" " + lista.get(i).getItem().getTitulo(), i, 0);
            tmLista.setValueAt(" " + lista.get(i).getCliente().getNome(), i, 1);
            tmLista.setValueAt(lista.get(i).getDataEmprestimo().format(formatter), i, 2);
            tmLista.setValueAt(lista.get(i).getDataDevolucaoPrevista().format(formatter), i, 3);
            
            if(lista.get(i).getDataDevolucao() == null){               
                tmLista.setValueAt("-", i, 4);
                tmLista.setValueAt("Em aberto", i, 5);
                
            } else if(lista.get(i).getDataDevolucao() != null && !lista.get(i).isMultaPaga()){               
                tmLista.setValueAt(emp.get(i).getDataDevolucao().format(formatter), i, 4);
                tmLista.setValueAt("Com multa*", i, 5);
                
            }else {
                tmLista.setValueAt(lista.get(i).getDataDevolucao().format(formatter), i, 4);
                tmLista.setValueAt("Finalizado", i, 5);
            }
            
            tmLista.setValueAt(lista.get(i).getValorMulta(), i, 6);
        }
          
    }
    
    public void listarEmprestimosComMulta(ArrayList<Emprestimo> emp){
        limparTabela();
        
        ArrayList<Emprestimo> lista = new ArrayList<Emprestimo>(emp);        
        Collections.sort(lista, new SortByData());

        String[] linha = new String[] {null, null, null, null, null, null, null};
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        int l = 0;
        
        for (int i = 0; i < emp.size(); i++) {
            
            if(lista.get(i).getDataDevolucao() != null && !lista.get(i).isMultaPaga()){
                tmLista.addRow(linha);
                //tmLista.setValueAt(emp.get(i).getID(), l, 0);
                tmLista.setValueAt(" " + lista.get(i).getItem().getTitulo(), l, 0);
                tmLista.setValueAt(" " + lista.get(i).getCliente().getNome(), l, 1);
                tmLista.setValueAt(lista.get(i).getDataEmprestimo().format(formatter), l, 2);
                tmLista.setValueAt(lista.get(i).getDataDevolucaoPrevista().format(formatter), l, 3);
                tmLista.setValueAt(lista.get(i).getDataDevolucao().format(formatter), l, 4);
                tmLista.setValueAt("Com multa*", l, 5);
                tmLista.setValueAt(lista.get(i).getValorMulta(), l, 6);
                l++;
            } 
        }
          
    }
    
    
    private void limparTabela() {       
        while (tmLista.getRowCount() > 0) {            
            tmLista.removeRow(0);
        }
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
            java.util.logging.Logger.getLogger(JFHistoricoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFHistoricoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFHistoricoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFHistoricoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFHistoricoEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
