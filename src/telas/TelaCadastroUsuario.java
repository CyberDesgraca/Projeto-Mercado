/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Helis
 */
public class TelaCadastroUsuario extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroUsuario() {
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

        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        txtNome1 = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        btnDSalvar = new javax.swing.JButton();
        cmbCargo = new javax.swing.JComboBox<>();
        lblRepSenha = new javax.swing.JLabel();
        txtRepSenha = new javax.swing.JTextField();

        setTitle("Cadastro de Usuário");
        getContentPane().setLayout(null);

        lblSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(20, 70, 70, 30);

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(140, 70, 160, 30);

        txtNome1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome1);
        txtNome1.setBounds(140, 20, 380, 30);

        lblNome1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome1.setText("Usuário:");
        getContentPane().add(lblNome1);
        lblNome1.setBounds(20, 20, 70, 30);

        lblCargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCargo.setText("Cargo:");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(20, 180, 70, 30);

        btnDSalvar.setBackground(new java.awt.Color(255, 255, 204));
        btnDSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDSalvar.setText("Salvar");
        btnDSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDSalvar);
        btnDSalvar.setBounds(20, 240, 100, 30);

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Caixa", "Balconista" }));
        cmbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCargoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCargo);
        cmbCargo.setBounds(140, 180, 160, 30);

        lblRepSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRepSenha.setText("Repita a Senha:");
        getContentPane().add(lblRepSenha);
        lblRepSenha.setBounds(20, 120, 120, 30);

        txtRepSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRepSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtRepSenha);
        txtRepSenha.setBounds(140, 120, 160, 30);

        setSize(new java.awt.Dimension(557, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnDSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSalvarActionPerformed
        try {
            Connection conexao;
            PreparedStatement st;
             Class.forName("com.mysql.jdbc.Driver");
            
            if(txtSenha.getText().equals(txtRepSenha.getText())){//Só realiza a função se a senha for igual ao repita senha
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoestoque", "root", "123456");
            st = conexao.prepareStatement ("INSERT INTO usuario VALUES(?, ?, ?)");
            st.setString(1, txtNome1.getText());
            st.setString(2, txtSenha.getText());
            st.setString(3, cmbCargo.getSelectedItem().toString());
            st.executeUpdate(); //Executa o comando INSERT acima
            JOptionPane.showMessageDialog(btnDSalvar,"Dados salvos com sucesso");
            txtNome1.setText("");
            txtSenha.setText("");
            txtRepSenha.setText("");
            txtNome1.requestFocus();
            
            }else {//negativa para o caso do erro de digitação da senha
            JOptionPane.showMessageDialog(null, "As senhas não coincidem");
            txtSenha.requestFocus();
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(btnDSalvar,"Você não tem o driver na biblioteca");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(btnDSalvar,"Algum parâmetro do banco de dados está incorreto!");
        }
    }//GEN-LAST:event_btnDSalvarActionPerformed

    private void cmbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCargoActionPerformed

    private void txtRepSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepSenhaActionPerformed

    private void txtNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDSalvar;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblRepSenha;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtRepSenha;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}