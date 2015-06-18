package DAO;

import Bean.Professor;
import Util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProfessorDAO {
    ConectaBanco conecta;

    public ProfessorDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();
    }
    public void inserirProfessor(Professor professor) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("insert into tbusuario(Nome, CPF, Telefone, Endereco, Cidade, Estado,Status) values (?,?,?,?,?,?,?)");

                  preStat.setString(1, professor.getNome());
                  preStat.setString(2, professor.getCpf());
                  preStat.setString(3, professor.getTelCelular());
                  preStat.setString(4, professor.getEndereco());
                  preStat.setString(5, professor.getCidade());
                  preStat.setString(6, professor.getEstado());
                  preStat.setString(7, professor.getStatus());
                  preStat.execute();
                   // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       
    }

}