package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import Util.*;
import javax.swing.JOptionPane;
import Bean.Usuario;

public class UsuarioDAO {
        ConectaBanco conecta;
        public UsuarioDAO(){
             conecta = new ConectaBanco();
             conecta.conexao();
        }
    
        public void inserirUsuario(Usuario usuario) {
            try {
                  PreparedStatement preStat;
                  preStat = conecta.connection.prepareStatement ("insert into tbusuario(Nome, CPF, Telefone, Endereco, Cidade, Estado) values (?,?,?,?,?,?)");
                  preStat.setString(1, usuario.getNome());
                  preStat.setString(2, usuario.getCpf());
                  preStat.setString(3, usuario.getTelefone());
                  preStat.setString(4, usuario.getEndereco());
                  preStat.setString(5, usuario.getCidade());
                  preStat.setString(6, usuario.getEstado());
                  preStat.execute();
                       
                  JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        
            }
                catch (SQLException e){  
                    throw new RuntimeException(e); 
           }
         //   return null;
         } 
        
}
