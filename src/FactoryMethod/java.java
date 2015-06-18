package FactoryMethod; 

import javax.swing.JOptionPane;

public class java implements Livros{
   @Override
    public void exibirDados(){
         JOptionPane.showMessageDialog(null,"Titulo: Java na Web \n" +
                                            "Autor: Neto antoni\n" +
                                            "Edição: 1 ed\n" +
                                            "Eitora: Atras\n" +
                                            "Ano ed: 2009\n" +
                                            "40 Unidade disponiveis no CERES \n"+
                                            "Setor de Sistemas de Informação");
    }
    
    
}
