/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.gui;

import br.edu.ifnmg.projetoPOO.Usuario;
import br.edu.ifnmg.projetoPOO.dao.UsuarioDao;

/**
 *
 * @author Filip
 */
public class RemoveUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form RemoverUsuario
     */
    public RemoveUsuario() {
        initComponents();
        
        fmtCpfRemoveUsuario.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAvisoRemocao = new javax.swing.JLabel();
        btnCancelarRemocao = new javax.swing.JButton();
        btnRemoverUsuario = new javax.swing.JButton();
        fmtCpfRemoveUsuario = new javax.swing.JFormattedTextField();
        lblCpf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remove Usuário");

        lblAvisoRemocao.setText("Informe o CPF do usuário que será REMOVIDO:");

        btnCancelarRemocao.setText("Cancelar");
        btnCancelarRemocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRemocaoActionPerformed(evt);
            }
        });

        btnRemoverUsuario.setText("Remover");
        btnRemoverUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverUsuarioActionPerformed(evt);
            }
        });

        try {
            fmtCpfRemoveUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCpf.setText("CPF:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblAvisoRemocao)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(btnCancelarRemocao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemoverUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCpf)
                        .addGap(18, 18, 18)
                        .addComponent(fmtCpfRemoveUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvisoRemocao)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(fmtCpfRemoveUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverUsuario)
                    .addComponent(btnCancelarRemocao)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRemocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRemocaoActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarRemocaoActionPerformed

    private void btnRemoverUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverUsuarioActionPerformed
        Usuario usuarioRemocao = new Usuario();
        usuarioRemocao.setCpf(Long.parseLong(fmtCpfRemoveUsuario.getValue().toString().replaceAll("[-.]", "")));
        usuarioRemocao.setId(usuarioRemocao.getCpf());
        
        UsuarioDao usuarioDao = new UsuarioDao();
        
        // Se existe alguém com esse cpf, então remove
        if(usuarioDao.localizarPorId(usuarioRemocao.getId()) != null ){
            usuarioDao.excluir(usuarioRemocao);
            dispose();
        }
        else{
            fmtCpfRemoveUsuario.requestFocus();
            System.out.println("Nenhum usuário encontrado com o CPF informado! Tente novamente.");
        }
        
        
    }//GEN-LAST:event_btnRemoverUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(RemoveUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemoveUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemoveUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemoveUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemoveUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarRemocao;
    private javax.swing.JButton btnRemoverUsuario;
    private javax.swing.JFormattedTextField fmtCpfRemoveUsuario;
    private javax.swing.JLabel lblAvisoRemocao;
    private javax.swing.JLabel lblCpf;
    // End of variables declaration//GEN-END:variables
}
