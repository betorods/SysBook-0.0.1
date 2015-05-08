package DAO;
/**
 *
 * @author Alberto
 */
import Bean.Emprestimo;
import Util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EmprestimoDAO {
    
       ConectaBanco conecta;
        public EmprestimoDAO(){
             conecta = new ConectaBanco();
             conecta.conexao();
        }
    
        public void inserirEmprestimo(Emprestimo emprestimo) {
            try {
                  PreparedStatement preStat;
                  preStat = conecta.connection.prepareStatement ("Insert into tbemprestimo(id_usuario, id_livro, dataEmprestimo, dataDevolucao) values(?,?,?,?)");
                  preStat.setInt(1, emprestimo.getId_usuario());
                  preStat.setInt(2, emprestimo.getId_livro());
                  preStat.setLong(3, emprestimo.getDataEmprestimo());
                  preStat.setLong(4, emprestimo.getDataEntrega());
                  preStat.setLong(5, emprestimo.getDataEntrega());
                  preStat.execute();
                       
                  JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        
            }
                catch (SQLException e){  
                    throw new RuntimeException(e); 
           }
         //   return null;
         }  
}
