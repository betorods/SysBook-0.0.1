/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import FactoryMethod.FabricaLivros;
import FactoryMethod.Livros;
import FactoryMethod.fabricaDireito;
import FactoryMethod.fabricaSistemas;
import Util.Conexao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import sistemabibliotecario.BuscaUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import net.proteanit.sql.DbUtils;
import view.TelaPrincipal;

/**
 *
 * @author Alberto
 */
public class BuscarLivro extends javax.swing.JFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
  //  private String Dep;

    public BuscarLivro() throws ClassNotFoundException {
        initComponents();
        conecta = Conexao.conexao();
        // listarLivros();
    }

    public void listarLivros() {
        String sql = "Select *from TBlivro order by id_Livro Asc"; // order by codigo Desc ou Asc para ordenar
        try {
            pst = conecta.prepareStatement(sql);

            rs = pst.executeQuery();
            tabBuscLivro.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisaLivro() {
        String sql = "Select id_livro,titulo,autor,edicao, editora, ano, curso from TBlivro WHERE titulo like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, tituloLivro.getText() + "%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            tabBuscLivro.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisaLivro1() {
        String sql = "Select id_livro,titulo,autor,edicao, editora, ano from TBlivro WHERE id_livro like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, codigoLivro.getText() + "%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            tabBuscLivro.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisaLivro2() {
        String sql = "Select id_livro,titulo,autor,edicao, editora, ano from TBlivro WHERE autor like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, autorLivro.getText() + "%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            tabBuscLivro.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

 /*   public void Departamento() {

        if (this.Sistemas.isSelected()) {
            tituloLivro.setEditable(true);
            autorLivro.setEditable(true);
            codigoLivro.setEditable(true);

        }
        if (this.Direito.isSelected()) {
            tituloLivro.setEditable(true);
            autorLivro.setEditable(true);
            codigoLivro.setEditable(true);
        }
    }*/

    public void MostrarItens(){
        int seleciona = tabBuscLivro.getSelectedRow();
        codigoLivro.setText(tabBuscLivro.getModel().getValueAt(seleciona, 0).toString());
        tituloLivro.setText(tabBuscLivro.getModel().getValueAt(seleciona, 1).toString());
        autorLivro.setText(tabBuscLivro.getModel().getValueAt(seleciona, 2).toString());
        DepCurso.setText(tabBuscLivro.getModel().getValueAt(seleciona, 6).toString());
    }
    
    public void BuscaFactory() {
       String aux1 = tituloLivro.getText();
       String aux2 = DepCurso.getText();
       
       if (aux1.equals("Processo") && aux2.equals("Direito")){
            FabricaLivros fabrica = new fabricaDireito();
            Livros livros = fabrica.criaLivros2();
            livros.exibirDados();
        }
       else if (aux1.equals("intitulação") && aux2.equals("Direito")){
            FabricaLivros fabrica = new fabricaDireito();
            Livros livros = fabrica.criaLivros();
            livros.exibirDados();
        }
        else if (aux1.equals("Java") && aux2.equals("Sistemas")){
            FabricaLivros fabrica = new fabricaSistemas();
            Livros livros = fabrica.criaLivros();
            livros.exibirDados();
        }
        else if (aux1.equals("Banco de Dados") && aux2.equals("Sistemas")){
            FabricaLivros fabrica = new fabricaSistemas();
            Livros livros = fabrica.criaLivros2();
            livros.exibirDados();
        }
        else {
            JOptionPane.showMessageDialog(null, "Livro não Cadastrdo no FactoryMethod. ");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curso = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        salvar = new javax.swing.JButton();
        voltar1 = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabBuscLivro = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigoLivro = new javax.swing.JTextField();
        tituloLivro = new javax.swing.JTextField();
        autorLivro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        DepCurso = new javax.swing.JTextField();
        Informacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 150, 0, 0));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        salvar.setText("Editar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        voltar1.setText("Voltar");
        voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar1ActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tabBuscLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabBuscLivroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabBuscLivro);

        jLabel2.setText("Autor:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Formulario de Busca de Livro");

        jLabel4.setText("Codigo:");

        codigoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoLivroActionPerformed(evt);
            }
        });
        codigoLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoLivroKeyReleased(evt);
            }
        });

        tituloLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloLivroActionPerformed(evt);
            }
        });
        tituloLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tituloLivroKeyReleased(evt);
            }
        });

        autorLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorLivroActionPerformed(evt);
            }
        });
        autorLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                autorLivroKeyReleased(evt);
            }
        });

        jLabel1.setText("Titulo:");

        DepCurso.setEditable(false);
        DepCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepCursoActionPerformed(evt);
            }
        });
        DepCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DepCursoKeyReleased(evt);
            }
        });

        Informacao.setText("Informação");
        Informacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Informacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(voltar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(autorLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                            .addComponent(tituloLivro)))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DepCurso))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, limpar, salvar, voltar1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(codigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(autorLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DepCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(limpar)
                    .addComponent(voltar1)
                    .addComponent(salvar)
                    .addComponent(Informacao))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, limpar, salvar, voltar1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tituloLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloLivroActionPerformed

    private void autorLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autorLivroActionPerformed

    private void codigoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoLivroActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            new Cadastro.EditarLivros().show();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_salvarActionPerformed

    private void voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar1ActionPerformed
        new view.TelaPrincipal().show();
        this.setVisible(false);
    }//GEN-LAST:event_voltar1ActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        tituloLivro.setText("");
        codigoLivro.setText("");
        autorLivro.setText("");
    }//GEN-LAST:event_limparActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tituloLivroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tituloLivroKeyReleased
        pesquisaLivro();
        codigoLivro.setText("");
        autorLivro.setText("");
    }//GEN-LAST:event_tituloLivroKeyReleased

    private void autorLivroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autorLivroKeyReleased
        pesquisaLivro2();
    }//GEN-LAST:event_autorLivroKeyReleased

    private void codigoLivroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoLivroKeyReleased
        pesquisaLivro1();
    }//GEN-LAST:event_codigoLivroKeyReleased

    private void DepCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepCursoActionPerformed

    private void DepCursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DepCursoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_DepCursoKeyReleased

    private void tabBuscLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabBuscLivroMouseClicked
        MostrarItens();
    }//GEN-LAST:event_tabBuscLivroMouseClicked

    private void InformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformacaoActionPerformed
        BuscaFactory();
    }//GEN-LAST:event_InformacaoActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BuscarLivro().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BuscarLivro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DepCurso;
    private javax.swing.JButton Informacao;
    private javax.swing.JTextField autorLivro;
    private javax.swing.JTextField codigoLivro;
    private javax.swing.ButtonGroup curso;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpar;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabBuscLivro;
    private javax.swing.JTextField tituloLivro;
    private javax.swing.JButton voltar1;
    // End of variables declaration//GEN-END:variables

}
