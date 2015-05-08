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
            try {
                  PreparedStatement preStat;
                  preStat = conecta.connection.prepareStatement("Insert into tblivro(titulo,autor,edicao,editora,ano) values(?,?,?,?,?)");
                  preStat.setString(1, livros.getTitulo());
                  preStat.setString(2, livros.getAutor());
                  preStat.setString(3, livros.getEdicao());
                  preStat.setString(4, livros.getEditora());
                  preStat.setString(5, livros.getAno());
                  
                  preStat.execute();
                       
                  JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        
            }
                catch (SQLException e){  
                    throw new RuntimeException(e); 
           }
         //   return null;
         } 

    
}
