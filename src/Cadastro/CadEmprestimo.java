package Cadastro;

/**
 *
 * @author Alberto
 */
import Bean.Usuario;
import Util.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import EmailObeserver.ObserverConcreto;
import Function.PegarHora;
import strategy.GerenciaStrategy;

public class CadEmprestimo extends javax.swing.JFrame {

    static String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection conecta;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    ResultSet rs1;

    public CadEmprestimo() throws ClassNotFoundException {
        initComponents();
        conecta = Conexao.conexao();
        PegarHora hora = new PegarHora();
        String aux = hora.Hora();
        dataEmprestimo.setText(aux);

    }

    public void mostraItens() {
        int seleciona = tabEmpUsuario.getSelectedRow();
        codUsuario.setText(tabEmpUsuario.getModel().getValueAt(seleciona, 0).toString());
        nomeUsuarioEscolhido.setText(tabEmpUsuario.getModel().getValueAt(seleciona, 1).toString());
        StatusUsuario.setText(tabEmpUsuario.getModel().getValueAt(seleciona, 2).toString());
    }

    /* public String StatusDoUsuario() {
     String aux = null;
     aux = StatusUsuario.getText();
     //JOptionPane.showMessageDialog(null, aux);
     return aux;
     } */
    public void mostraItensLivro() {
        int seleciona = tabEmpLivro.getSelectedRow();
        codLivro.setText(tabEmpLivro.getModel().getValueAt(seleciona, 0).toString());
        nomeLivro.setText(tabEmpLivro.getModel().getValueAt(seleciona, 1).toString());
    }

    public void mostraItensEmprestimo() {
        int seleciona = tabDevolucao.getSelectedRow();

        codigoUsuarioDevolucao.setText(tabDevolucao.getModel().getValueAt(seleciona, 0).toString());
        codigoLivroDevolucao.setText(tabDevolucao.getModel().getValueAt(seleciona, 1).toString());
        //  dataEntrega.setText(tabDevolucao.getModel().getValueAt(seleciona,4).toString());
    }

   /* public void Strategy() {
        String status;
        //   GerenciaStrategy gerencia = new GerenciaStrategy();
    }*/

    public void disponivel() {
        String sql = "Select *from TBlivro where id_Livro =? and emprestimo = ?";
        String aux = "1";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, codigoLivro.getText());
            pst.setString(2, aux);

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Disponivel. ");
                mostraItensLivro();
            } else {
                JOptionPane.showMessageDialog(null, "Livro emprestado. ");
                codLivro.setText("");
                nomeLivro.setText("");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void StatusUsuario() {
        int seleciona = tabEmpUsuario.getSelectedRow();
        dataEmprestimo.setText(tabEmpUsuario.getModel().getValueAt(seleciona, 0).toString());
        nomeUsuarioEscolhido.setText(tabEmpUsuario.getModel().getValueAt(seleciona, 1).toString());

    }

    public void atualizarEmprestimo() {
        String sql = "Update TBlivro set emprestimo = ? where id_Livro = ?";
        aux = "0";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, aux);
            pst.setInt(2, Integer.parseInt(codigoLivro.getText()));
            pst.execute();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void atualizarDevolucao() {
        String sql = "Update TBlivro set emprestimo = ? where id_Livro = ?";
        aux = "1";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, aux);
            pst.setInt(2, Integer.parseInt(codigoLivroDevolucao.getText()));
            pst.execute();
            //    JOptionPane.showMessageDialog(null,aux + "Test");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisaUsuario() {
        String sql = "Select id_usuario, nome, Status from TBusuario where nome like ?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, NomeUsuario.getText() + "%");// %para quando apagar trazer de volta as informações do BD.

            rs = pst.executeQuery();
            tabEmpUsuario.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisaLivro() {
        String sql = "Select id_livro, titulo from TBlivro where id_livro like ?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, codigoLivro.getText() + "%");// %para quando apagar trazer de volta as informações do BD.

            rs = pst.executeQuery();
            tabEmpLivro.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisaEmprestimo() {
        String sql = "Select id_usuario, id_livro, dataEmprestimo, dataDevolucao, dataEntrega from tbemprestimo where id_usuario like ?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, codigoUsuarioDevolucao.getText() + "%");// %para quando apagar trazer de volta as informações do BD.

            rs = pst.executeQuery();
            tabDevolucao.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void Emprestimo() {

        String sql = "Insert into tbemprestimo(id_usuario, id_livro, dataEmprestimo, dataDevolucao) values(?,?,?,?)";
        // String aux = "0";
        try {
            pst = conecta.prepareStatement(sql);

            pst.setString(1, codUsuario.getText());
            pst.setString(2, codLivro.getText());
            pst.setString(3, dataEmprestimo.getText());
            pst.setString(4, dataDevolucao.getText());
            //   pst.setString(5, aux);            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso!", "Emprestimo", JOptionPane.INFORMATION_MESSAGE);
            atualizarEmprestimo();
            //     editar();
            new ObserverConcreto().mensagem();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void editar() {

        String sql1 = "Update tblivro set codigo_usuario = ? where id_Livro = ?";
        try {
            pst = conecta.prepareStatement(sql1);
            pst.setInt(1, Integer.parseInt(dataEmprestimo.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(null, dataEmprestimo + "Cadastrado com sucesso!", "Cadastro com sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void devolver() {
        String sql = "Update tbemprestimo set id_livro = ?, dataEntrega = ? where id_usuario = ?";
        try {
            pst = conecta.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(codigoLivroDevolucao.getText()));
            pst.setString(2, dataEntrega.getText());
            pst.setInt(3, Integer.parseInt(codigoUsuarioDevolucao.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(null, "Devolução feita com sucesso!", "Devolução", JOptionPane.INFORMATION_MESSAGE);
            atualizarDevolucao();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void verificador() {
        String sql = "Select *from tbemprestimo where dataEntrega = ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, dataEntrega.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Já devolvido. ");
            } else {
                devolver();
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void limpar() {
        NomeUsuario.setText("");
        codigoLivro.setText("");
        codLivro.setText("");
        dataEmprestimo.setText("");
        nomeUsuarioEscolhido.setText("");
        codUsuario.setText("");
        nomeLivro.setText("");
        StatusUsuario.setText("");
        dataDevolucao.setText("");
        dataEntrega.setText("");
      
        codigoUsuarioDevolucao.setText("");
        codigoLivroDevolucao.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        NomeUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        codigoLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabEmpUsuario = new javax.swing.JTable();
        dataEmprestimo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomeUsuarioEscolhido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabEmpLivro = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        codLivro = new javax.swing.JTextField();
        nomeLivro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        ConfimarEmprestimo = new javax.swing.JButton();
        StatusUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        codUsuario = new javax.swing.JTextField();
        dataDevolucao = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        codigoUsuarioDevolucao = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabDevolucao = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        dataEntrega = new javax.swing.JFormattedTextField();
        jButton10 = new javax.swing.JButton();
        limpar1 = new javax.swing.JButton();
        voltar1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        codigoLivroDevolucao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 150, 0, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Emprestimo");

        jLabel4.setText("Nome do Usuario:");

        NomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeUsuarioActionPerformed(evt);
            }
        });
        NomeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NomeUsuarioKeyReleased(evt);
            }
        });

        jLabel3.setText("Código do Livro:");

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

        jLabel2.setText("Data do Emprestimo");

        tabEmpUsuario.setAutoCreateRowSorter(true);
        tabEmpUsuario.setBorder(new javax.swing.border.MatteBorder(null));
        tabEmpUsuario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabEmpUsuario.setAutoscrolls(false);
        tabEmpUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabEmpUsuario.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tabEmpUsuario.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        tabEmpUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabEmpUsuarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabEmpUsuario);

        dataEmprestimo.setEnabled(false);

        jLabel7.setText("Codigo do Usuario:");

        jLabel8.setText("Nome:");

        nomeUsuarioEscolhido.setEnabled(false);
        nomeUsuarioEscolhido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeUsuarioEscolhidoActionPerformed(evt);
            }
        });

        tabEmpLivro.setAutoCreateRowSorter(true);
        tabEmpLivro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabEmpLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabEmpLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabEmpLivro);

        jLabel9.setText("Codigo do Livro:");

        codLivro.setEnabled(false);

        nomeLivro.setEnabled(false);

        jLabel10.setText("Titulo:");

        jLabel11.setText("Data devolução:");

        jButton8.setText("Cancelar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        ConfimarEmprestimo.setText("Confimar");
        ConfimarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfimarEmprestimoActionPerformed(evt);
            }
        });

        StatusUsuario.setEnabled(false);

        jLabel6.setText("Status");

        codUsuario.setEnabled(false);
        codUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codUsuarioActionPerformed(evt);
            }
        });

        dataDevolucao.setEnabled(false);
        dataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDevolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeUsuarioEscolhido, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(nomeLivro)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ConfimarEmprestimo)
                        .addGap(46, 46, 46)
                        .addComponent(voltar)
                        .addGap(59, 59, 59)
                        .addComponent(limpar)
                        .addGap(44, 44, 44)
                        .addComponent(jButton8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(StatusUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addComponent(dataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(codigoLivro)
                            .addComponent(dataDevolucao)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ConfimarEmprestimo, jButton8, limpar, voltar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(nomeUsuarioEscolhido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(codLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(nomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfimarEmprestimo)
                    .addComponent(limpar)
                    .addComponent(voltar)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {nomeLivro, nomeUsuarioEscolhido});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLivro, dataEmprestimo});

        jTabbedPane1.addTab("Emprestar", jPanel2);

        jLabel13.setText("Codigo do Usuario:");

        codigoUsuarioDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoUsuarioDevolucaoActionPerformed(evt);
            }
        });
        codigoUsuarioDevolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoUsuarioDevolucaoKeyReleased(evt);
            }
        });

        tabDevolucao.setAutoCreateRowSorter(true);
        tabDevolucao.setBorder(new javax.swing.border.MatteBorder(null));
        tabDevolucao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabDevolucao.setAutoscrolls(false);
        tabDevolucao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabDevolucao.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tabDevolucao.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        tabDevolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDevolucaoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabDevolucao);

        jLabel20.setText("Data de Entrega:");

        try {
            dataEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataEntregaActionPerformed(evt);
            }
        });

        jButton10.setText("Cancelar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        limpar1.setText("Limpar");
        limpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpar1ActionPerformed(evt);
            }
        });

        voltar1.setText("Voltar");
        voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar1ActionPerformed(evt);
            }
        });

        jButton11.setText("Confimar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        codigoLivroDevolucao.setEnabled(false);
        codigoLivroDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoLivroDevolucaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Codigo Livro");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11)
                            .addGap(18, 18, 18)
                            .addComponent(voltar1)
                            .addGap(29, 29, 29)
                            .addComponent(limpar1)
                            .addGap(26, 26, 26)
                            .addComponent(jButton10))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(codigoUsuarioDevolucao, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(31, 31, 31)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20)
                                        .addComponent(dataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(codigoLivroDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(247, 247, 247))))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton10, jButton11, limpar1, voltar1});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoUsuarioDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLivroDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(limpar1)
                    .addComponent(voltar1)
                    .addComponent(jButton10))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Devolução", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeUsuarioActionPerformed

    private void codigoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoLivroActionPerformed

    private void NomeUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomeUsuarioKeyReleased
        pesquisaUsuario();
    }//GEN-LAST:event_NomeUsuarioKeyReleased

    private void tabEmpUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabEmpUsuarioMouseClicked
        mostraItens();

        String aux = StatusUsuario.getText();
        GerenciaStrategy ger = new GerenciaStrategy(aux);

        String aux2 = ger.verificador2();
        dataDevolucao.setText(aux2);

    }//GEN-LAST:event_tabEmpUsuarioMouseClicked

    private void tabEmpLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabEmpLivroMouseClicked
        disponivel();
        //   mostraItensLivro();
    }//GEN-LAST:event_tabEmpLivroMouseClicked

    private void codigoLivroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoLivroKeyReleased
        pesquisaLivro();
    }//GEN-LAST:event_codigoLivroKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        limpar();

    }//GEN-LAST:event_limparActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        new view.TelaPrincipal().show();
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void ConfimarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfimarEmprestimoActionPerformed
//      disponivel();
        Emprestimo();
        limpar();

    }//GEN-LAST:event_ConfimarEmprestimoActionPerformed

    private void codigoUsuarioDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoUsuarioDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoUsuarioDevolucaoActionPerformed

    private void codigoUsuarioDevolucaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoUsuarioDevolucaoKeyReleased
        pesquisaEmprestimo();
    }//GEN-LAST:event_codigoUsuarioDevolucaoKeyReleased

    private void tabDevolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDevolucaoMouseClicked
        mostraItensEmprestimo();
    }//GEN-LAST:event_tabDevolucaoMouseClicked

    private void dataEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataEntregaActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void limpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar1ActionPerformed
        limpar();
    }//GEN-LAST:event_limpar1ActionPerformed

    private void voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar1ActionPerformed
        new view.TelaPrincipal().show();
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_voltar1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        verificador();
        //      codigoUsuarioDevolucao.setText("");
        //      dataEntrega.setText("");
        //      codigoLivroDevolucao.setText("");

//        devolver();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void codigoLivroDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoLivroDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoLivroDevolucaoActionPerformed

    private void nomeUsuarioEscolhidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUsuarioEscolhidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeUsuarioEscolhidoActionPerformed

    private void codUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codUsuarioActionPerformed

    private void dataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataDevolucaoActionPerformed

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
            java.util.logging.Logger.getLogger(CadEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadEmprestimo().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CadEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfimarEmprestimo;
    private javax.swing.JTextField NomeUsuario;
    private javax.swing.JTextField StatusUsuario;
    private javax.swing.JTextField codLivro;
    private javax.swing.JTextField codUsuario;
    private javax.swing.JTextField codigoLivro;
    private javax.swing.JTextField codigoLivroDevolucao;
    private javax.swing.JTextField codigoUsuarioDevolucao;
    private javax.swing.JTextField dataDevolucao;
    private javax.swing.JTextField dataEmprestimo;
    private javax.swing.JFormattedTextField dataEntrega;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JButton limpar1;
    private javax.swing.JTextField nomeLivro;
    private javax.swing.JTextField nomeUsuarioEscolhido;
    private javax.swing.JTable tabDevolucao;
    private javax.swing.JTable tabEmpLivro;
    private javax.swing.JTable tabEmpUsuario;
    private javax.swing.JButton voltar;
    private javax.swing.JButton voltar1;
    // End of variables declaration//GEN-END:variables
    private String aux;
}
