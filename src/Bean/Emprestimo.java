package Bean;

/**
 *
 * @author Alberto
 */
public class Emprestimo {
    private char dataEmprestimo;
    private char dataDevolucao;
    private char dataEntrega;
    private int id_usuario;
    private int id_livro;
    
   public Emprestimo(){
       
   } 

   public Emprestimo(char dataEmprestimo, char dataDevolucao, char dataEntrega, int id_livro, int id_usuario) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataEntrega = dataEntrega;
        this.id_livro = id_livro;
        this.id_usuario = id_usuario;
    }
   
    public char getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(char dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public char getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(char dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public char getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(char dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
    
}
