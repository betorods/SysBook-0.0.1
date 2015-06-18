package Bean;

public class Professor extends Usuario{
    private int SIAPE;

    public Professor(int SIAPE, String nome, String endereco, String cidade, String estado, String telefone, String cpf, String status) {
        super(nome, endereco, cidade, estado, telefone, cpf, status);
        this.SIAPE = SIAPE;
    }
    public Professor(){
        
    }

    public int getSIAPE() {
        return SIAPE;
    }

    public void setSIAPE(int SIAPE) {
        this.SIAPE = SIAPE;
    }
}
