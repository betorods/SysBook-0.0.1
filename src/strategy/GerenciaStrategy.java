package strategy;

import Cadastro.CadEmprestimo;
import javax.swing.JOptionPane;

public class GerenciaStrategy {

    protected UsuarioStrategy usuario;
    private String Prof = "Professor";
    private String Al = "Aluno";
    private String aux;

    public GerenciaStrategy(String status) {
        if (status.equals(Prof)) {
            JOptionPane.showMessageDialog(null, "O Usuario é um " + status + "\n Tem 30 Dias de prazo de emprestimo");
            usuario = new ProfessorStrategy();

        } else if (status.equals(Al)) {
            JOptionPane.showMessageDialog(null, "O Usuario é um " + status + "\n Tem 10 Dias de prazo de emprestimo");
            usuario = new AlunoStrategy();
        } else {
            JOptionPane.showMessageDialog(null, "Não tem nada em Status");
        }
       
    }

    public String verificador2() {
        aux = usuario.exibirUsuario();
        return aux;
    }

   /* public String verificador() throws ClassNotFoundException {

     //   PegarHora hora = new PegarHora();
        //   String aux = hora.Hora();
        CadEmprestimo emprestimo = new CadEmprestimo();
        String status = emprestimo.StatusDoUsuario();
        JOptionPane.showMessageDialog(null, " Erro 2 " + status);

        new GerenciaStrategy(status);

        return status;
    }*/

    /*  public static void main(String[] args) throws ClassNotFoundException {
     String status;

     CadEmprestimo mostra = new CadEmprestimo();
     status = mostra.StatusDoUsuario();
      
     new GerenciaStrategy(status);

     }*/
}
