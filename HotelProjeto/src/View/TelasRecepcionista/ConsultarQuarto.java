/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.TelasRecepcionista;

import View.TelasGerais.Login;
import View.TelasRecepcionista.MenuRecepcionista;
import com.placeholder.PlaceHolder;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import model.bean.Quarto;
import model.dao.QuartoDAO;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sousa
 */
public class ConsultarQuarto extends javax.swing.JFrame {
    /**
     * Creates new form ConsultarQuarto
     */
    public ConsultarQuarto() {
        initComponents();
        listarQuartos();
    }
     public void listarQuartos() {
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        QuartoDAO qDAO = new QuartoDAO();

        for (Quarto h : qDAO.listar()) {
            tabela.addRow(new Object[]{
                
                h.getNumQuarto(),
                h.getPreco(),
                h.getAndar(),
                h.getDisponivel(),
                h.getDescricao()
                

            });
            
        }

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
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLblLogo = new javax.swing.JLabel();
        jLblFechar = new javax.swing.JLabel();
        jLblMinimizar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(840, 591));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("SUNN", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Consultar Quarto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        jTable1.setBackground(new java.awt.Color(176, 224, 230));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número", "Preço", "Andar", "Disponibilidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 610, 170));

        jPanel5.setBackground(new java.awt.Color(70, 130, 180));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLblLogo.setFont(new java.awt.Font("SUNN", 1, 24)); // NOI18N
        jLblLogo.setForeground(new java.awt.Color(255, 255, 255));
        jLblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/star.png"))); // NOI18N
        jLblLogo.setText("Hotel");
        jPanel5.add(jLblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLblFechar.setFont(new java.awt.Font("SUNN", 1, 36)); // NOI18N
        jLblFechar.setForeground(new java.awt.Color(255, 255, 255));
        jLblFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/x.png"))); // NOI18N
        jLblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblFecharMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLblFecharMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLblFecharMouseReleased(evt);
            }
        });
        jPanel5.add(jLblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 30, 30));

        jLblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/minus.png"))); // NOI18N
        jLblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblMinimizarMouseClicked(evt);
            }
        });
        jPanel5.add(jLblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reply (1).png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 60, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/painel.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 670, 560));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/265-swimming-pool-22-hotel-barcelo-costa-cancun_tcm7-126728.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblFecharMouseClicked
        // TODO add your handling code here:
        dispose();
        jLblFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/x vermelho.png")));
    }//GEN-LAST:event_jLblFecharMouseClicked

    private void jLblFecharMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblFecharMousePressed
        // TODO add your handling code here:
        jLblFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/x vermelho.png")));
    }//GEN-LAST:event_jLblFecharMousePressed

    private void jLblFecharMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblFecharMouseReleased
        // TODO add your handling code here:
        jLblFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/x.png")));
    }//GEN-LAST:event_jLblFecharMouseReleased

    private void jLblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblMinimizarMouseClicked
        // TODO add your handling code here:
        Login l = new Login ();
        l.setState(Login.ICONIFIED);
    }//GEN-LAST:event_jLblMinimizarMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        MenuRecepcionista l = new MenuRecepcionista();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reply (2).png")));
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
        // TODO add your handling code here:
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reply (1).png")));
    }//GEN-LAST:event_jLabel10MouseReleased

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
            java.util.logging.Logger.getLogger(ConsultarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarQuarto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLblFechar;
    private javax.swing.JLabel jLblLogo;
    private javax.swing.JLabel jLblMinimizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
