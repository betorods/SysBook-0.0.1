package DAO;

import Bean.Aluno;
import Util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlunoDAO {
    ConectaBanco conecta;

    public AlunoDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();
    }
    public void inserirAlunos(Aluno alunos) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("insert into tbusuario(Nome, CPF, Telefone, Endereco, Cidade, Estado,Status) values (?,?,?,?,?,?,?)");

                  preStat.setString(1, alunos.getNome());
                  preStat.setString(2, alunos.getCpf());
                  preStat.setString(3, alunos.getTelCelular());
                  preStat.setString(4, alunos.getEndereco());
                  preStat.setString(5, alunos.getCidade());
                  preStat.setString(6, alunos.getEstado());
                  preStat.setString(7, alunos.getStatus());
                  preStat.execute();
            // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //   return "index";
    }

}
