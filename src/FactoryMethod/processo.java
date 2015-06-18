package FactoryMethod; 

import javax.swing.JOptionPane;

public class processo implements Livros{
    @Override
    public void exibirDados(){
        JOptionPane.showMessageDialog(null,"Titulo: Direito Penal\n" +
                                           "Autor:  Cleber Masson\n" +
                                           "Edição: 9 ed\n" +
                                           "Eitora: Atras\n" +
                                           "Ano ed: 2010\n" +
                                           "30 Unidade disponiveis no CERES ");
    }
}
