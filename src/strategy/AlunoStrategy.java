package strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AlunoStrategy implements UsuarioStrategy {

    @Override
    public String exibirUsuario() {
        Calendar calendar = new GregorianCalendar();

        calendar.add(Calendar.DAY_OF_MONTH, +10);
        //obtem a data do sistema +10  
        String dataAluno = calendar.get(Calendar.DAY_OF_MONTH) + "/"
                + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);

        return dataAluno;

    }

}
