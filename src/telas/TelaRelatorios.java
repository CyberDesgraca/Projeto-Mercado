package telas;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Helis
 */
public class TelaRelatorios extends javax.swing.JFrame {

    /**
     * Creates new form TelaRelatorios
     */
    public TelaRelatorios() {
        initComponents();
        txtNomeRelatorio.setVisible(false);
        jblNomeRelatorio.setVisible(false);
        txtCategoriaRelatorio.setVisible(false);
        jblCategoriaRelatorio.setVisible(false);
        jblBuscarRelatorios.setVisible(true);
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
        jblNomeRelatorio = new javax.swing.JLabel();
        jblCategoriaRelatorio = new javax.swing.JLabel();
        txtNomeRelatorio = new javax.swing.JTextField();
        txtCategoriaRelatorio = new javax.swing.JTextField();
        cmbTipoRelatorio = new javax.swing.JComboBox<>();
        jblBuscarRelatorios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Tipo de Relatório");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(23, 20, 110, 30);

        jblNomeRelatorio.setText("Nome:");
        getContentPane().add(jblNomeRelatorio);
        jblNomeRelatorio.setBounds(310, 20, 70, 50);

        jblCategoriaRelatorio.setText("Categoria:");
        getContentPane().add(jblCategoriaRelatorio);
        jblCategoriaRelatorio.setBounds(310, 20, 70, 30);

        txtNomeRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeRelatorioActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomeRelatorio);
        txtNomeRelatorio.setBounds(390, 20, 280, 30);
        getContentPane().add(txtCategoriaRelatorio);
        txtCategoriaRelatorio.setBounds(390, 20, 280, 30);

        cmbTipoRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Por Categoria", "Por Nome" }));
        cmbTipoRelatorio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoRelatorioItemStateChanged(evt);
            }
        });
        cmbTipoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoRelatorioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipoRelatorio);
        cmbTipoRelatorio.setBounds(150, 20, 130, 30);

        jblBuscarRelatorios.setText("Buscar");
        jblBuscarRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblBuscarRelatoriosActionPerformed(evt);
            }
        });
        getContentPane().add(jblBuscarRelatorios);
        jblBuscarRelatorios.setBounds(30, 60, 110, 23);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Marca", "Preço"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 620, 360);

        setSize(new java.awt.Dimension(696, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jblBuscarRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblBuscarRelatoriosActionPerformed
        String tipoRelatorio;
        tipoRelatorio = cmbTipoRelatorio.getSelectedItem().toString();
        //2 - Conectar com o Banco de dados
        try {
            Connection conexao;
            PreparedStatement st;
            ResultSet resultado;
            DefaultTableModel defTable;
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoestoque", "root", "123456");
            //Verifica o conteúdo do comboBox de tipo de relatório
            if (tipoRelatorio.equalsIgnoreCase("Geral")) {
                st = conexao.prepareStatement("SELECT * FROM cadastros");
                resultado = st.executeQuery();
                defTable = (DefaultTableModel) tblProdutos.getModel();
                defTable.setRowCount(0);
                while (resultado.next()) {
                    Object[] linha = {resultado.getString("codigo"), resultado.getString("nome"), resultado.getString("marca"), resultado.getString("preco")};
                    defTable.addRow(linha);
                }
            } else if (tipoRelatorio.equalsIgnoreCase("Por categoria")) {
                st = conexao.prepareStatement("SELECT * FROM cadastros WHERE marca LIKE ?");
                st.setString(1, "%" + txtCategoriaRelatorio.getText() + "%");
                //"% entre a busca no banco de dados ajuda a não necessitar digitar o nome completo pra encontrar"
                resultado = st.executeQuery();
                defTable = (DefaultTableModel) tblProdutos.getModel();
                defTable.setRowCount(0);
                while (resultado.next()) {
                    Object[] linha = {resultado.getString("codigo"), resultado.getString("nome"), resultado.getString("marca"), resultado.getString("preco")};
                    defTable.addRow(linha);
                }
            } else if (tipoRelatorio.equalsIgnoreCase("Por nome")) {
                st = conexao.prepareStatement("SELECT * FROM cadastros WHERE nome LIKE ?");
                st.setString(1, "%" + txtNomeRelatorio.getText() + "%");
                resultado = st.executeQuery();
                defTable = (DefaultTableModel) tblProdutos.getModel();
                defTable.setRowCount(0);
                while (resultado.next()) {
                    Object[] linha = {resultado.getString("codigo"), resultado.getString("nome"), resultado.getString("marca"), resultado.getString("preco")};
                    defTable.addRow(linha);
                }
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algum parâmetro do BD está incorreto" + ex.getMessage());
        }


    }//GEN-LAST:event_jblBuscarRelatoriosActionPerformed

    private void cmbTipoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoRelatorioActionPerformed

    private void cmbTipoRelatorioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoRelatorioItemStateChanged
        String Tipo;
        Tipo = cmbTipoRelatorio.getSelectedItem().toString();
        if (Tipo.equalsIgnoreCase("Geral")) {
            txtNomeRelatorio.setVisible(false);
            jblNomeRelatorio.setVisible(false);
            txtCategoriaRelatorio.setVisible(false);
            jblCategoriaRelatorio.setVisible(false);

        } else if (Tipo.equalsIgnoreCase("Por nome")) {
            txtNomeRelatorio.setVisible(true);
            jblNomeRelatorio.setVisible(true);
            txtCategoriaRelatorio.setVisible(false);
            jblCategoriaRelatorio.setVisible(false);
        } else if (Tipo.equalsIgnoreCase("Por categoria")) {
            txtNomeRelatorio.setVisible(false);
            jblNomeRelatorio.setVisible(false);
            txtCategoriaRelatorio.setVisible(true);
            jblCategoriaRelatorio.setVisible(true);
        }
    }//GEN-LAST:event_cmbTipoRelatorioItemStateChanged

    private void txtNomeRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTipoRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jblBuscarRelatorios;
    private javax.swing.JLabel jblCategoriaRelatorio;
    private javax.swing.JLabel jblNomeRelatorio;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCategoriaRelatorio;
    private javax.swing.JTextField txtNomeRelatorio;
    // End of variables declaration//GEN-END:variables
}
