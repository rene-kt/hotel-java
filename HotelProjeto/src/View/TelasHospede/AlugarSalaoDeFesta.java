/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.TelasHospede;

import javax.swing.table.DefaultTableModel;
import model.bean.Hospede;
import model.bean.SalaoFesta;
import model.dao.HospedeDAO;
import model.dao.SaloesDAO;

/**
 *
 * @author Rebeca
 */
public class AlugarSalaoDeFesta extends javax.swing.JFrame {

    /**
     * Creates new form listaPromoções
     */
    public AlugarSalaoDeFesta() {
        initComponents();
        listarSaloes();
    }

    public void listarSaloes() {
        DefaultTableModel tabela = (DefaultTableModel) jTable4.getModel();
        SaloesDAO qDAO = new SaloesDAO();
        
        for (SalaoFesta q : qDAO.listar()) {
            tabela.addRow(new Object[]{
                q.getId(),
                q.getPreco(),
                q.getHorario(),
            });

        }

    }

    public void setar_salao(){
        
        SalaoFesta s = new SalaoFesta();
        Hospede h = new Hospede();
        SaloesDAO sdao = new SaloesDAO();
        HospedeDAO hdao = new HospedeDAO();
        
        
        int setar_preco = jTable4.getSelectedRow();
        Float preco = (Float) jTable4.getModel().getValueAt(setar_preco, 1);
        
        int setar_id = jTable4.getSelectedRow();
        int valor_id = (int) jTable4.getModel().getValueAt(setar_id, 0);
        
        h.setId(Hospede.getIdaux());
        h.setAcumuladorPreco(preco);
        
        s.setId(valor_id);
        s.setDisponibilidade("Indisponível");
        
        hdao.gastosServicos(h);
        sdao.alugar_salao(s);
        
        
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
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLblLogo2 = new javax.swing.JLabel();
        jLblFechar = new javax.swing.JLabel();
        jLblMinimizar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel7.setPreferredSize(new java.awt.Dimension(840, 591));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("SUNN", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SAlões disponíveis");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jButton4.setBackground(new java.awt.Color(144, 238, 144));
        jButton4.setFont(new java.awt.Font("SUNN", 0, 26)); // NOI18N
        jButton4.setText("Alugar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 150, -1));

        jTable4.setBackground(new java.awt.Color(176, 224, 230));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Preço", "Horário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setResizable(false);
            jTable4.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 620, 120));

        jPanel8.setBackground(new java.awt.Color(70, 130, 180));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLblLogo2.setFont(new java.awt.Font("SUNN", 1, 24)); // NOI18N
        jLblLogo2.setForeground(new java.awt.Color(255, 255, 255));
        jLblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/star.png"))); // NOI18N
        jLblLogo2.setText("Hotel");
        jPanel8.add(jLblLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

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
        jPanel8.add(jLblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 30, 30));

        jLblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/minus.png"))); // NOI18N
        jLblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblMinimizarMouseClicked(evt);
            }
        });
        jPanel8.add(jLblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reply (1).png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel12MouseReleased(evt);
            }
        });
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 60, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/painel.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 670, 560));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/265-swimming-pool-22-hotel-barcelo-costa-cancun_tcm7-126728.jpg"))); // NOI18N
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 580));

        jButton3.setBackground(new java.awt.Color(144, 238, 144));
        jButton3.setFont(new java.awt.Font("SUNN", 0, 26)); // NOI18N
        jButton3.setText("Consultar");
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }//GEN-LAST:event_jLblMinimizarMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        MenuHospede l = new MenuHospede();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reply (2).png")));
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseReleased
        // TODO add your handling code here:
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reply (1).png")));
    }//GEN-LAST:event_jLabel12MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            setar_salao();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AlugarSalaoDeFesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlugarSalaoDeFesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlugarSalaoDeFesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlugarSalaoDeFesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlugarSalaoDeFesta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLblFechar;
    private javax.swing.JLabel jLblLogo2;
    private javax.swing.JLabel jLblMinimizar;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
