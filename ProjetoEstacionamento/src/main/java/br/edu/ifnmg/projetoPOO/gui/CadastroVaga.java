/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.gui;

import br.edu.ifnmg.projetoPOO.Vaga;
import br.edu.ifnmg.projetoPOO.dao.VagaDao;

/**
 *
 * @author Filip
 */
public class CadastroVaga extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastroVaga
     */
    public CadastroVaga() {
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

        fmtPlaca = new javax.swing.JFormattedTextField();
        lblPlaca = new javax.swing.JLabel();
        fmtPlacaVaga = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        boxVaga = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnCancelarVaga = new javax.swing.JButton();
        btnCadastrarVaga = new javax.swing.JButton();

        try {
            fmtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-AAAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPlaca.setText("Placa");

        try {
            fmtPlacaVaga.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-AAAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Descição");

        boxVaga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));

        jLabel2.setText("Vaga");

        btnCancelarVaga.setText("Cancelar");
        btnCancelarVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVagaActionPerformed(evt);
            }
        });

        btnCadastrarVaga.setText("Cadastrar");
        btnCadastrarVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVagaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fmtPlacaVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(lblPlaca)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(boxVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 147, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarVaga)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrarVaga)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fmtPlacaVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarVaga)
                    .addComponent(btnCadastrarVaga))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVagaActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarVagaActionPerformed

    private void btnCadastrarVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVagaActionPerformed
        Vaga vaga = new Vaga();
        vaga.setPlaca(fmtPlacaVaga.getValue().toString().replaceAll("[-]", ""));
        vaga.setDescricao(txtDesc.getText());
        vaga.setNumero( Long.parseLong( boxVaga.getItemAt(boxVaga.getSelectedIndex()) ) );
        vaga.setId(vaga.getNumero());
        
        // Se a vaga estiver liberada, vou cadastrar
        VagaDao vagaDao = new VagaDao();
        if(vagaDao.localizarPorId(vaga.getId()) == null){
            vagaDao.salvar(vaga);
            dispose();
        }
        // Se não tiver liberar, tentou outro vaga
        else {
            System.out.println("Vaga em uso! tente outra.");
        // Limpa os campos da tela
//        fmtPlacaVaga.setText(null);
//        txtDesc.setText(null);
            boxVaga.requestFocus();
        }
        
    }//GEN-LAST:event_btnCadastrarVagaActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroVaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVaga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxVaga;
    private javax.swing.JButton btnCadastrarVaga;
    private javax.swing.JButton btnCancelarVaga;
    private javax.swing.JFormattedTextField fmtPlaca;
    private javax.swing.JFormattedTextField fmtPlacaVaga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JTextField txtDesc;
    // End of variables declaration//GEN-END:variables
}
