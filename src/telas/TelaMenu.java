package telas;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;

public class TelaMenu extends javax.swing.JFrame {

    public TelaMenu() {
        initComponents();
    }

    public TelaMenu(String usuario, String cargo) {
        initComponents();
        pnlCadastrarProdutos.setVisible(false);
        lblSaudacao.setText("Bem Vindo(a), " + usuario); //mensagem de boas vindas no label criado na tela menu
        //equalsIgnoreCase ele desativa o case sentive. identifica qualquer forma escrita
        btnExcluirProduto.setVisible(false);
        if (cargo.equalsIgnoreCase("caixa")) {
            chavear();
            //cadastrando as permissoes de visualização
            //ele puxa as permissoes do private chavear para evitar repetições

        } else if (cargo.equalsIgnoreCase("balconista")) {
            chavear();
        }
    }

    private void chavear() {
        //quando repete a mesma permissão para diferentes usuarios, evitando repetição no cod fonte
        //cadastrando as permissoes de visualização do usuario
        itmCadastrarProdutos.setVisible(false); //desabilita a visibiliade par o usuario caixa
        itmAlterarProdutos.setVisible(false);
        itmExcluirProdutos.setVisible(false);
        itmRelatorioProdutos.setVisible(true); // habilita a visibilidade para o usuario

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSalvarMenu = new javax.swing.JButton();
        lblSaudacao = new javax.swing.JLabel();
        pnlCadastrarProdutos = new javax.swing.JPanel();
        lblPainelPreco = new javax.swing.JLabel();
        txtPainelPreco = new javax.swing.JTextField();
        lblPainelCodigo = new javax.swing.JLabel();
        lblPainelNome = new javax.swing.JLabel();
        lblPainelMarca = new javax.swing.JLabel();
        txtPainelCodigo = new javax.swing.JTextField();
        txtPainelNome = new javax.swing.JTextField();
        txtPainelMarca = new javax.swing.JTextField();
        btnSalvarCadastroProduto = new javax.swing.JButton();
        btnConsultarProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        btnAlterarProduto = new javax.swing.JButton();
        jblOutrosRelatorios = new javax.swing.JButton();
        txtPainelQuantidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuProdutos = new javax.swing.JMenu();
        itmCadastrarProdutos = new javax.swing.JMenuItem();
        itmAlterarProdutos = new javax.swing.JMenuItem();
        itmExcluirProdutos = new javax.swing.JMenuItem();
        itmRelatorioProdutos = new javax.swing.JMenuItem();
        itmManualAjuda = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        getContentPane().setLayout(null);

        jToolBar1.setRollover(true);

        btnSalvarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/salvar.jpg"))); // NOI18N
        btnSalvarMenu.setFocusable(false);
        btnSalvarMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvarMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarMenuActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvarMenu);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(10, 410, 50, 30);

        lblSaudacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(lblSaudacao);
        lblSaudacao.setBounds(480, 10, 150, 40);

        pnlCadastrarProdutos.setLayout(null);

        lblPainelPreco.setText("Preço");
        pnlCadastrarProdutos.add(lblPainelPreco);
        lblPainelPreco.setBounds(20, 170, 110, 16);

        txtPainelPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPainelPrecoActionPerformed(evt);
            }
        });
        pnlCadastrarProdutos.add(txtPainelPreco);
        txtPainelPreco.setBounds(110, 160, 460, 30);

        lblPainelCodigo.setText("Código");
        pnlCadastrarProdutos.add(lblPainelCodigo);
        lblPainelCodigo.setBounds(20, 50, 120, 16);

        lblPainelNome.setText("Nome");
        pnlCadastrarProdutos.add(lblPainelNome);
        lblPainelNome.setBounds(20, 90, 120, 16);

        lblPainelMarca.setText("Marca");
        pnlCadastrarProdutos.add(lblPainelMarca);
        lblPainelMarca.setBounds(20, 130, 110, 16);

        txtPainelCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPainelCodigoActionPerformed(evt);
            }
        });
        pnlCadastrarProdutos.add(txtPainelCodigo);
        txtPainelCodigo.setBounds(110, 40, 460, 30);
        pnlCadastrarProdutos.add(txtPainelNome);
        txtPainelNome.setBounds(110, 80, 460, 30);
        pnlCadastrarProdutos.add(txtPainelMarca);
        txtPainelMarca.setBounds(110, 120, 460, 30);

        btnSalvarCadastroProduto.setText("Salvar");
        btnSalvarCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadastroProdutoActionPerformed(evt);
            }
        });
        pnlCadastrarProdutos.add(btnSalvarCadastroProduto);
        btnSalvarCadastroProduto.setBounds(20, 300, 72, 22);

        btnConsultarProduto.setText("Consultar");
        btnConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProdutoActionPerformed(evt);
            }
        });
        pnlCadastrarProdutos.add(btnConsultarProduto);
        btnConsultarProduto.setBounds(90, 300, 90, 22);

        btnExcluirProduto.setText("Excluir");
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });
        pnlCadastrarProdutos.add(btnExcluirProduto);
        btnExcluirProduto.setBounds(190, 300, 80, 22);

        btnAlterarProduto.setText("Alterar");
        btnAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarProdutoActionPerformed(evt);
            }
        });
        pnlCadastrarProdutos.add(btnAlterarProduto);
        btnAlterarProduto.setBounds(280, 300, 100, 22);

        jblOutrosRelatorios.setText("Outros Relatórios");
        jblOutrosRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblOutrosRelatoriosActionPerformed(evt);
            }
        });
        pnlCadastrarProdutos.add(jblOutrosRelatorios);
        jblOutrosRelatorios.setBounds(390, 300, 130, 22);
        pnlCadastrarProdutos.add(txtPainelQuantidade);
        txtPainelQuantidade.setBounds(110, 200, 460, 30);

        jLabel1.setText("Quantidade");
        pnlCadastrarProdutos.add(jLabel1);
        jLabel1.setBounds(20, 210, 70, 16);

        getContentPane().add(pnlCadastrarProdutos);
        pnlCadastrarProdutos.setBounds(10, 30, 600, 340);

        mnuProdutos.setMnemonic('P');
        mnuProdutos.setText("Produtos");

        itmCadastrarProdutos.setText("Cadastrar");
        itmCadastrarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastrarProdutosActionPerformed(evt);
            }
        });
        mnuProdutos.add(itmCadastrarProdutos);

        itmAlterarProdutos.setText("Alterar");
        itmAlterarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAlterarProdutosActionPerformed(evt);
            }
        });
        mnuProdutos.add(itmAlterarProdutos);

        itmExcluirProdutos.setText("Excluir");
        itmExcluirProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExcluirProdutosActionPerformed(evt);
            }
        });
        mnuProdutos.add(itmExcluirProdutos);

        itmRelatorioProdutos.setText("Relatório");
        itmRelatorioProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRelatorioProdutosActionPerformed(evt);
            }
        });
        mnuProdutos.add(itmRelatorioProdutos);

        jMenuBar1.add(mnuProdutos);

        itmManualAjuda.setMnemonic('A');
        itmManualAjuda.setText("Ajuda");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Manual");
        itmManualAjuda.add(jMenuItem5);

        jMenuBar1.add(itmManualAjuda);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(652, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itmExcluirProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmExcluirProdutosActionPerformed
        itmRelatorioProdutos.doClick(); //Clicar no excluir executa relatorios
        pnlCadastrarProdutos.setVisible(true);
        btnSalvarCadastroProduto.setVisible(false);
        btnConsultarProduto.setVisible(true);
        btnAlterarProduto.setVisible(false);
        btnExcluirProduto.setVisible(false);

    }//GEN-LAST:event_itmExcluirProdutosActionPerformed

    private void txtPainelPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPainelPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPainelPrecoActionPerformed

    private void btnSalvarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarMenuActionPerformed


    }//GEN-LAST:event_btnSalvarMenuActionPerformed


    private void txtPainelCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPainelCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPainelCodigoActionPerformed

    private void itmCadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastrarProdutosActionPerformed
        btnSalvarCadastroProduto.setVisible(true);
        btnConsultarProduto.setVisible(false);
        pnlCadastrarProdutos.setVisible(true); // ao clicar no botao cadastrar ativa a tela cadastrar
    }//GEN-LAST:event_itmCadastrarProdutosActionPerformed

    private void btnSalvarCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCadastroProdutoActionPerformed

        try {
            Connection conexao;
            PreparedStatement st;
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoestoque", "root", "123456");
            st = conexao.prepareStatement("INSERT INTO cadastros VALUES(?, ?, ?, ?, ?)");
            st.setString(1, txtPainelCodigo.getText());
            st.setString(2, txtPainelNome.getText());
            st.setString(3, txtPainelMarca.getText());
            st.setDouble(4, Double.parseDouble(txtPainelPreco.getText())); //numeros fracionados é necessário a conversao do double
            st.setString(5, txtPainelQuantidade.getText());
            st.executeUpdate();
            txtPainelCodigo.setText("");
            txtPainelNome.setText("");
            txtPainelMarca.setText("");
            txtPainelPreco.setText("");
            txtPainelQuantidade.setText("");
            txtPainelCodigo.requestFocus();//Cursor ficar piscando no campo após salvar

            JOptionPane.showMessageDialog(btnSalvarCadastroProduto, "Dados Salvos Com Sucesso!!");

        } catch (ClassNotFoundException ex) { //caso há algum erro no banco de dados
            JOptionPane.showMessageDialog(btnSalvarCadastroProduto, "Você não tem o driver na biblioteca" + ex.getMessage()); //Vê o código do erro
        } catch (SQLException ex) {

            if (ex.getErrorCode() == 1062) { //erro 1062 é cadastro duplicado

                JOptionPane.showMessageDialog(btnSalvarCadastroProduto, "Este Código de produto já existe" + ex.getErrorCode());
            } else {
                JOptionPane.showMessageDialog(null, "Erro número " + ex.getErrorCode() + "\nEntre em contato com o administrador e informe o número do erro");
            }
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarCadastroProdutoActionPerformed

    private void itmRelatorioProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRelatorioProdutosActionPerformed
        pnlCadastrarProdutos.setVisible(true);
        btnSalvarCadastroProduto.setVisible(false);
        btnConsultarProduto.setVisible(true);
        btnAlterarProduto.setVisible(false);
        btnExcluirProduto.setVisible(false);

    }//GEN-LAST:event_itmRelatorioProdutosActionPerformed

    private void btnConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProdutoActionPerformed
        if (txtPainelCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o código do produto");
            txtPainelCodigo.requestFocus();
            return; // para a execução nesta linha (stop)       
        }
        try {
            Connection conexao;
            PreparedStatement st;
            ResultSet resultado;
            //Conexão com o BD
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoestoque", "root", "123456");
            //Busca o produto na tabela produtos do BD
            st = conexao.prepareStatement("SELECT * FROM cadastros WHERE codigo=?");
            st.setString(1, txtPainelCodigo.getText());
            resultado = st.executeQuery(); //Executa o SELECT criado acima
            if (resultado.next()) { // Se encontrou o código do produto na tabela
                txtPainelNome.setText(resultado.getString("nome"));
                txtPainelMarca.setText(resultado.getString("marca"));
                txtPainelPreco.setText(resultado.getString("preco"));
                btnExcluirProduto.setVisible(true); //Mostra o botão excluir após encontrar os dados
                btnAlterarProduto.setVisible(true);

            } else { //Senão encontrou o produto
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
                txtPainelCodigo.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algum parâmetro do BD está incorreto");
        }

    }//GEN-LAST:event_btnConsultarProdutoActionPerformed

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        try {
            Connection conexao;
            PreparedStatement st;
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoestoque", "root", "123456");
            st = conexao.prepareStatement("DELETE FROM cadastros WHERE codigo=?");
            st.setString(1, txtPainelCodigo.getText());
            int res = st.executeUpdate(); // executa o comando
            if (res == 1) {
                // quando retorna 1 é que o sistema encontrou no banco de dados
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
                txtPainelCodigo.setText(""); //deixa o campo em branco apos excluir
                txtPainelNome.setText("");
                txtPainelMarca.setText("");
                txtPainelPreco.setText("");
                //quando confirma a exclusão desabilita os botoes abaixo
                btnExcluirProduto.setVisible(false);
                btnAlterarProduto.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto com este código");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algum parâmetro do BD está incorreto" + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void btnAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarProdutoActionPerformed
        try {
            Connection conexao;
            PreparedStatement st;
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoestoque", "root", "123456");
            st = conexao.prepareStatement("UPDATE cadastros SET nome =?, marca =?, preco=?, quantidade=? WHERE codigo=?");
            st.setString(1, txtPainelNome.getText());
            st.setString(2, txtPainelMarca.getText());
            st.setString(3, txtPainelPreco.getText());
            st.setString(4, txtPainelQuantidade.getText());
            st.setString(5, txtPainelCodigo.getText());
            st.executeUpdate(); //Executa o comando SQL UPDATE
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
            txtPainelCodigo.setText("");
            txtPainelNome.setText("");
            txtPainelMarca.setText("");
            txtPainelPreco.setText("");
            txtPainelQuantidade.setText("");
            pnlCadastrarProdutos.setVisible(true);
            btnSalvarCadastroProduto.setVisible(false);
            btnConsultarProduto.setVisible(true);
            btnAlterarProduto.setVisible(false);
            btnExcluirProduto.setVisible(false);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algum parâmetro do BD está incorreto" + ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarProdutoActionPerformed

    private void jblOutrosRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblOutrosRelatoriosActionPerformed
        TelaRelatorios tela;
        tela = new TelaRelatorios();
        tela.setVisible(true);
    }//GEN-LAST:event_jblOutrosRelatoriosActionPerformed

    private void itmAlterarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAlterarProdutosActionPerformed
        itmRelatorioProdutos.doClick(); //Clicar no excluir executa relatorios
        pnlCadastrarProdutos.setVisible(true);
        btnConsultarProduto.setVisible(true);
        btnAlterarProduto.setVisible(true);
    }//GEN-LAST:event_itmAlterarProdutosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarProduto;
    private javax.swing.JButton btnConsultarProduto;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnSalvarCadastroProduto;
    private javax.swing.JButton btnSalvarMenu;
    private javax.swing.JMenuItem itmAlterarProdutos;
    private javax.swing.JMenuItem itmCadastrarProdutos;
    private javax.swing.JMenuItem itmExcluirProdutos;
    private javax.swing.JMenu itmManualAjuda;
    private javax.swing.JMenuItem itmRelatorioProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jblOutrosRelatorios;
    private javax.swing.JLabel lblPainelCodigo;
    private javax.swing.JLabel lblPainelMarca;
    private javax.swing.JLabel lblPainelNome;
    private javax.swing.JLabel lblPainelPreco;
    private javax.swing.JLabel lblSaudacao;
    private javax.swing.JMenu mnuProdutos;
    private javax.swing.JPanel pnlCadastrarProdutos;
    private javax.swing.JTextField txtPainelCodigo;
    private javax.swing.JTextField txtPainelMarca;
    private javax.swing.JTextField txtPainelNome;
    private javax.swing.JTextField txtPainelPreco;
    private javax.swing.JTextField txtPainelQuantidade;
    // End of variables declaration//GEN-END:variables
}
