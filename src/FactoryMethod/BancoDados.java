package FactoryMethod;

import javax.swing.JOptionPane;

public class BancoDados implements Livros {

    @Override
    public void exibirDados() {
        JOptionPane.showMessageDialog(null, "Titulo: Sistemas de Banco de Dados \n"
                + "Autor: Navathe\n"
                + "Edição: 6 ed\n"
                + "Eitora: Atras\n"
                + "Ano ed: 1995\n"
                + "35 Unidade disponiveis no CERES \n"
                + "Setor de Sistema de informação");
    }
}
