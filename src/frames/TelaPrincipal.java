package frames;

import biblioteca.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlla
 */
public class TelaPrincipal extends javax.swing.JFrame {

    Biblioteca biblioteca;
    
    /**
     * Creates new form TelaPrincipal
     * @param bib
     */
    public TelaPrincipal(Biblioteca bib) {
        this();
        
        this.biblioteca = bib;
        String caminhoRelativo = "/wallpaper.png";
        
    }
    
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCliente = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuLivros = new javax.swing.JMenu();
        jMenuItemLivro = new javax.swing.JMenuItem();
        jMenuItemPeriodico = new javax.swing.JMenuItem();
        jMenuItemListaLivros = new javax.swing.JMenuItem();
        jMenuEmprestimo = new javax.swing.JMenu();
        jMenuItemCriarEmp = new javax.swing.JMenuItem();
        jMenuItemBuscarEmp = new javax.swing.JMenuItem();
        jMenuItemCancelarReserva = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemHistEmp = new javax.swing.JMenuItem();
        jMenuItemTotalMulta = new javax.swing.JMenuItem();
        jMenuAjuda = new javax.swing.JMenu();
        jMenuItemInfo = new javax.swing.JMenuItem();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento de Empréstimos");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/booksat.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(978, 645));
        jLabel1.setMinimumSize(new java.awt.Dimension(978, 645));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuCliente.setText("Cliente");

        jMenuItemCliente.setText("Buscar Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuCliente.add(jMenuItemCliente);

        jMenuItem1.setText("Listar todos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuCliente.add(jMenuItem1);

        jMenuBar1.add(jMenuCliente);

        jMenuLivros.setText("Acervo");

        jMenuItemLivro.setText("Consultar Livro");
        jMenuItemLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLivroActionPerformed(evt);
            }
        });
        jMenuLivros.add(jMenuItemLivro);

        jMenuItemPeriodico.setText("Consultar Periódicos");
        jMenuItemPeriodico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPeriodicoActionPerformed(evt);
            }
        });
        jMenuLivros.add(jMenuItemPeriodico);

        jMenuItemListaLivros.setText("Listar todos os itens");
        jMenuItemListaLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListaLivrosActionPerformed(evt);
            }
        });
        jMenuLivros.add(jMenuItemListaLivros);

        jMenuBar1.add(jMenuLivros);

        jMenuEmprestimo.setText("Empréstimos e Reservas");

        jMenuItemCriarEmp.setText("Criar Emprestimo / Reserva");
        jMenuItemCriarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCriarEmpActionPerformed(evt);
            }
        });
        jMenuEmprestimo.add(jMenuItemCriarEmp);

        jMenuItemBuscarEmp.setText("Buscar Emprestimo");
        jMenuItemBuscarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBuscarEmpActionPerformed(evt);
            }
        });
        jMenuEmprestimo.add(jMenuItemBuscarEmp);

        jMenuItemCancelarReserva.setText("Cancelar Reserva");
        jMenuEmprestimo.add(jMenuItemCancelarReserva);

        jMenuBar1.add(jMenuEmprestimo);

        jMenu1.setText("Relatórios");

        jMenuItemHistEmp.setText("Histórico de Empréstimos");
        jMenuItemHistEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHistEmpActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemHistEmp);

        jMenuItemTotalMulta.setText("Total de Multas Pendentes");
        jMenuItemTotalMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTotalMultaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemTotalMulta);

        jMenuBar1.add(jMenu1);

        jMenuAjuda.setText("Ajuda");

        jMenuItemInfo.setText("Informações");
        jMenuItemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInfoActionPerformed(evt);
            }
        });
        jMenuAjuda.add(jMenuItemInfo);

        jMenuItemSobre.setText("Sobre");
        jMenuAjuda.add(jMenuItemSobre);

        jMenuBar1.add(jMenuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Biblioteca");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemInfoActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        
       JFCliente jfc = new JFCliente(this, biblioteca);
       jfc.setLocationRelativeTo(jPanel1);
       jfc.setVisible(true);
       
       // Desativa funcionalidades da tabela principal
       this.setEnabled(false);
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLivroActionPerformed
        // TODO add your handling code here:
        
       JFLivro jfl = new JFLivro(this, biblioteca);
       jfl.setLocationRelativeTo(jPanel1);
       jfl.setVisible(true);
       
       // Desativa funcionalidades da tabela principal
       this.setEnabled(false);
    }//GEN-LAST:event_jMenuItemLivroActionPerformed

    private void jMenuItemBuscarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBuscarEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemBuscarEmpActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jMenuItemPeriodicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPeriodicoActionPerformed
        // TODO add your handling code here:
       JFPeriodico jfp = new JFPeriodico(this, biblioteca);
       jfp.setLocationRelativeTo(jPanel1);
       jfp.setVisible(true);
       
       // Desativa funcionalidades da tabela principal
       this.setEnabled(false);
    }//GEN-LAST:event_jMenuItemPeriodicoActionPerformed

    private void jMenuItemCriarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCriarEmpActionPerformed
        // TODO add your handling code here:
        
       JFCriaEmprestimo jfe = new JFCriaEmprestimo(this, biblioteca);
       jfe.setLocationRelativeTo(jPanel1);
       jfe.setVisible(true);
       
       // Desativa funcionalidades da tabela principal
       this.setEnabled(false);
    }//GEN-LAST:event_jMenuItemCriarEmpActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
       JFListaClientes jfc = new JFListaClientes(this, biblioteca);
       jfc.setLocationRelativeTo(jPanel1);
       jfc.setVisible(true);
       
       // Desativa funcionalidades da tabela principal
       this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemListaLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListaLivrosActionPerformed
        // TODO add your handling code here:
       JFListaTitulos jft = new JFListaTitulos(this, biblioteca);
       jft.setLocationRelativeTo(jPanel1);
       jft.setVisible(true);
       
       // Desativa funcionalidades da tabela principal
       this.setEnabled(false);
    }//GEN-LAST:event_jMenuItemListaLivrosActionPerformed

    private void jMenuItemTotalMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTotalMultaActionPerformed
        // TODO add your handling code here:
        double multa = this.biblioteca.totalMultasPendentes();
        JOptionPane.showMessageDialog(null, "Total de multas pendentes: " + multa, "Multas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItemTotalMultaActionPerformed

    private void jMenuItemHistEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHistEmpActionPerformed
        // TODO add your handling code here:
        
       JFHistoricoEmprestimo jfh = new JFHistoricoEmprestimo(this, biblioteca);
       jfh.setLocationRelativeTo(jPanel1);
       jfh.setVisible(true);
       
       // Desativa funcionalidades da tabela principal
       this.setEnabled(false);
    }//GEN-LAST:event_jMenuItemHistEmpActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCliente;
    private javax.swing.JMenu jMenuEmprestimo;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemBuscarEmp;
    private javax.swing.JMenuItem jMenuItemCancelarReserva;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemCriarEmp;
    private javax.swing.JMenuItem jMenuItemHistEmp;
    private javax.swing.JMenuItem jMenuItemInfo;
    private javax.swing.JMenuItem jMenuItemListaLivros;
    private javax.swing.JMenuItem jMenuItemLivro;
    private javax.swing.JMenuItem jMenuItemPeriodico;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenuItem jMenuItemTotalMulta;
    private javax.swing.JMenu jMenuLivros;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
