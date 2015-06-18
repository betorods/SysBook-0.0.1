package EmailObeserver;

import Bean.Usuario;
import java.util.HashSet;
import java.util.Set;

public class Email {

    private boolean status = false;
    private Set<Observer> interessados = new HashSet<Observer>();
    private String nomeEmail;

    public Email(String nomeEmail) {
       this.nomeEmail = nomeEmail;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        for (Observer interessado : interessados) {
            interessado.notificacao(this);
        }

    }

    public void registraInteressado(Observer interessado) {
        this.interessados.add(interessado);
    }

    public String getNomeEmail() {
        return nomeEmail;
    }

    public void setNomeEmail(String nomeEmail) {
        this.nomeEmail = nomeEmail;
    }

}
