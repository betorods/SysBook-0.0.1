package FactoryMethod;

public class Cliente {

    public static void main(String[] args) {
        FabricaLivros fabrica = new fabricaSistemas();
        Livros livros = fabrica.criaLivros();
        livros.exibirDados();
        System.out.println();

        fabrica = new fabricaSistemas();
        livros = fabrica.criaLivros2();
        livros.exibirDados();
        System.out.println();

        fabrica = new fabricaDireito();
        livros = fabrica.criaLivros();
        livros.exibirDados();
        System.out.println();

        fabrica = new fabricaDireito();
        livros = fabrica.criaLivros2();
        livros.exibirDados();
        System.out.println();
    }

}
