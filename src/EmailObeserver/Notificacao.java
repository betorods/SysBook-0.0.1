package EmailObeserver;

import javax.swing.JOptionPane;

public class Notificacao implements Observer {
    @Override
    public void notificacao(Email email) {
        JOptionPane.showMessageDialog(null,"  O " + email.getNomeEmail() + 
                           " - enivado com sucesso.");
    }
}