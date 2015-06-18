package builder;

import Bean.Usuario;
import javax.swing.JOptionPane;


public class Teste {
    public void rodar(){
        BibliotecaDirector listar = new BibliotecaDirector(
        new AlunoBuilder());
       
        
        listar.construirUsuario();
        UsuarioProduct use = listar.getUsuario();
        
        JOptionPane.showMessageDialog(null,"Nome: " + use.nome + "\n" + "Cpf: " + use.cpf);

        System.out.println();
    }
    
}
