/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Bean.Livros;
import Util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class LivrosDAO {
            ConectaBanco conecta;
        public LivrosDAO(){
             conecta = new ConectaBanco();
             conecta.conexao();
        }
    
        public void inserirLivros(Livros livros) {
            int aux = 1;
            try {
                  PreparedStatement preStat;
                  preStat = conecta.connection.prepareStatement("Insert into tblivro(titulo,autor,edicao,editora,ano,curso,emprestimo) values(?,?,?,?,?,?,?)");
                  preStat.setString(1, livros.getTitulo());
                  preStat.setString(2, livros.getAutor());
                  preStat.setString(3, livros.getEdicao());
                  preStat.setString(4, livros.getEditora());
                  preStat.setString(5, livros.getAno());
                  preStat.setString(6, livros.getCurso());
                  preStat.setInt(7, aux);
                  preStat.execute();
                       
                  JOptionPane.showMessageDialog(null, "Cadastro relizado com sucesso!");
        
            }
                catch (SQLException e){  
                    throw new RuntimeException(e); 
           }
         //   return null;
         } 

    
}
