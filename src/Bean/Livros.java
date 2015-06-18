package Bean;
/**
 *
 * @author Alberto
 */
public class Livros {
    private String autor;
    private String titulo;
    private String edicao;
    private String editora;
    private String ano;
    private String curso;
    
    public Livros(){
        
    }

    public Livros(String autor, String titulo, String edicao, String editora, String ano,String curso) {
        this.autor = autor;
        this.titulo = titulo;
        this.edicao = edicao;
        this.editora = editora;
        this.ano = ano;
        this.curso = curso;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    
}
