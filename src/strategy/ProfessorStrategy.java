package strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProfessorStrategy implements UsuarioStrategy {

    @Override
    public String exibirUsuario() {
        Calendar calendar = new GregorianCalendar();

        calendar.add(Calendar.DAY_OF_MONTH, +30);
        //obtem a data do sistema +30  
        String dataProfessor = calendar.get(Calendar.DAY_OF_MONTH) + "/"
                + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);

        return dataProfessor;
    }

}
