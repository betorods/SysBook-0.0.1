package FactoryMethod;

import javax.swing.JOptionPane;

public class intitulacao implements Livros
{
   
    @Override
    public void exibirDados(){
         JOptionPane.showMessageDialog(null,"Titulo: Intitulação do direito Privado\n" +
                                            "Autor: Sérgio Pinto martins\n" +
                                            "Edição: 5 ed\n" +
                                            "Eitora: Atras\n" +
                                            "Ano ed: 2003\n" +
                                            "25 Unidade disponiveis no CERES \n"+
                                            "Setor de Direitos");
    }
}
