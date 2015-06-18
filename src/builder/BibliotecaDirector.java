package builder;

import Cadastro.CadUsuario;

public class BibliotecaDirector {

    protected UsuarioBuilder listar;

    public BibliotecaDirector(UsuarioBuilder listar) {
        this.listar = listar;
    }

    public void construirUsuario(){
                
                
        listar.buildNome();
        listar.buildCpf(null);
        listar.buildEndereco(null);
        listar.buildCidade(null);
        listar.buildEstado(null);
        listar.buildTelCelular(null);
        listar.buildStatus(null);
    }

    public UsuarioProduct getUsuario() {
        return listar.getUsuario();
    }
}
