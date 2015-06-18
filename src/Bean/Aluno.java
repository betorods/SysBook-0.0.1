
package Bean;

public class Aluno extends Usuario{
    private int Matricula;
  //  private String status;

    public Aluno(int Matricula, String nome, String endereco, String cidade, String estado, String telefone, String cpf, String status) {
        super(nome, endereco, cidade, estado, telefone, cpf, status);
        this.Matricula = Matricula;
    }
    
    public Aluno(){
        
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }
    
}
