package EmailObeserver;

public class ObserverConcreto {
    
    public void mensagem(){
        Notificacao notificacao = new Notificacao();
       //teve o status alterado
        Email email = new Email(" E-mail: ");
        email.registraInteressado(notificacao);
        email.setStatus(true);
    }

}