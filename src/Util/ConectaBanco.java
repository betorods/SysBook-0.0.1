
//Adicionar biblioteca do banco de dados (Postgres)

package Util;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConectaBanco {
    
    public Statement statement; // responsável por preparar e realizar pesquisas no banco de dados
    public ResultSet resultSet; // responsável por armazenar o resultado de uma pesquisa passada para o statement
    public Connection connection;
    private final String driver;
    private final String caminho;
    private final String usuario;
    private final String senha;
    
    
    public ConectaBanco(){
        driver = "org.mysql.Driver"; // responsável por identificar o serviço de banco de dados
        caminho = "jdbc:mysql://127.0.0.1/biblioteca"; // responsável por setar o local do banco de dados
        usuario = "root";
        senha = "12345";
    }
    
    public void conexao(){ //responsável por realizar a conexão com o banco
        try { // tentativa inicial
            System.setProperty("jdbc.Drives", driver);//seta a propriedade do driver de conexão
            connection = DriverManager.getConnection(caminho, usuario, senha);//realiza a conexão com o banco
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException ex) { //exceção
            JOptionPane.showMessageDialog(null, "Erro de Conexão! /n Erro: "+ ex.getMessage());        
        }
    }
    
    public void executaSQL(String sql){
        try {
            statement = connection.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE, resultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de ExecutaSQL! /n Erro: "+ ex.getMessage());
        }
    }
    
    public void desonecta(){ // método para fechar a conexão com o banco de dados
        try {
            connection.close(); //fecha a conexão
            //JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a Conexão! /n Erro: "+ ex.getMessage());        
        }

        }
    }
    

