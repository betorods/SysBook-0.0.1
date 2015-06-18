package builder;

import javax.swing.JOptionPane;

public class Cliente {

    /*public static void main(String[] args) throws ClassNotFoundException {
        BibliotecaDirector listar = new BibliotecaDirector(
        new AlunoBuilder());

        listar.construirUsuario();
        UsuarioProduct use = listar.getUsuario();
        System.out.println("Carro: " + use.nome + "\n" + "Cpf: " + use.cpf);

        System.out.println();

    }*/
    
    
    public void teste(){
        
        BibliotecaDirector listar = new BibliotecaDirector(
        new AlunoBuilder());

        listar.construirUsuario();
        UsuarioProduct use = listar.getUsuario();
        JOptionPane.showMessageDialog(null,"Carro: " + use.nome + "\n" + "Cpf: " + use.cpf);

        System.out.println();
       // return use.nome;
    } 
    
}
