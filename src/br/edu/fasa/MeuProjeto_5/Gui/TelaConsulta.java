/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * JFConsulta.java
 *
 * Created on 19/11/2011, 20:41:20
 */
package br.edu.fasa.MeuProjeto_5.Gui;

import br.edu.fasa.MeuProjeto.Dao.CaoDao;
import br.edu.fasa.MeuProjeto.Util.Util;
import br.edu.fasa.MeuProjeto_5.Model.Cao;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deda
 */
public class TelaConsulta extends javax.swing.JFrame {

    private Cao cachorro;
    private CaoDao caoDao;

    /**
     * Creates new form JFConsulta
     */
    public TelaConsulta() {
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

        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jCForma = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTForma = new javax.swing.JTextField();
        jBProcessar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setTitle("SGAS - Sistema de Gerenciamento de Atendimento Social");

        jPanel1.setBackground(new java.awt.Color(185, 209, 234));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 1, 14), new java.awt.Color(0, 51, 153))); // NOI18N

        jCForma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Nome" }));
        jCForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCFormaActionPerformed(evt);
            }
        });

        jLabel1.setText("Forma de Consulta");

        jTForma.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jBProcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/fasa/MeuProjeto_5/Gui/ConsVagas.png"))); // NOI18N
        jBProcessar.setText("Processar");
        jBProcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcessarActionPerformed(evt);
            }
        });

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabela.getTableHeader().setReorderingAllowed(false);
        jTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMouseClicked(evt);
            }
        });
        jTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabelaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTabela);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCForma, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTForma, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jBProcessar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTForma, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCForma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBProcessar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jBProcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcessarActionPerformed
    
    
    String[] titulos = {"Código", "Nome", "Raça", "Cor", "Peso", "Idade", "Latido"};
    DefaultTableModel dtm = new DefaultTableModel();
    dtm.setColumnIdentifiers(titulos);

    cachorro = new Cao();
    caoDao = new CaoDao();
    ArrayList<Cao> resultado = new ArrayList<Cao>();
    
    if (jCForma.getSelectedIndex() == 0) {
        resultado.clear();
        resultado = caoDao.listaTodos();
    } else if (jCForma.getSelectedIndex() == 1) {
        resultado.clear();
        resultado = caoDao.listaPorNome(jTForma.getText());
    }

    Iterator<Cao> i = resultado.listIterator();

    while (i.hasNext()) {

        cachorro = i.next();
        dtm.addRow(new Object[]{cachorro.getCod(), cachorro.getNome(), cachorro.getRaca(), cachorro.getCor(),
            cachorro.getPeso(), cachorro.getIdade(), cachorro.getLatido()});
        jTabela.setModel(dtm); 
    }
    
    
    


}//GEN-LAST:event_jBProcessarActionPerformed

    private void jCFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCFormaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCFormaActionPerformed

    private void jTabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabelaKeyPressed
        if(evt.getKeyCode()== 10){
            int linha = jTabela.getSelectedRow();
            cachorro.setCod((int) jTabela.getValueAt(linha, 0));
            cachorro.setNome((String) jTabela.getValueAt(linha, 1));
            cachorro.setRaca((String) jTabela.getValueAt(linha, 2));
            cachorro.setCor((String) jTabela.getValueAt(linha, 3));
            cachorro.setPeso((float) jTabela.getValueAt(linha, 4));
            cachorro.setIdade((int) jTabela.getValueAt(linha, 5));
            cachorro.setLatido((String) jTabela.getValueAt(linha, 6));

            Util.getPrincipal().preencheTela(cachorro);
            Util.getConsulta().setVisible(false);
        }
    }//GEN-LAST:event_jTabelaKeyPressed

    private void jTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMouseClicked
        
        
    }//GEN-LAST:event_jTabelaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Util.getConsulta().setVisible(true);               
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBProcessar;
    private javax.swing.JComboBox jCForma;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTForma;
    private javax.swing.JTable jTabela;
    // End of variables declaration//GEN-END:variables
}
