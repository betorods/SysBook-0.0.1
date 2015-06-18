package builder;

//import Bean.Usuario;

import Cadastro.CadUsuario;


/**
 *
 * @author Ana Catarina
 */
 

public abstract class UsuarioBuilder {
	protected UsuarioProduct usuarioB = new UsuarioProduct();
        
        public UsuarioBuilder(){
            usuarioB= new UsuarioProduct();
        }
	
        
        public abstract void buildNome();
	public abstract void buildEndereco(String endereco);
	public abstract void buildCidade(String cidade);
	public abstract void buildTelCelular(String telCelular);
	public abstract void buildCpf(String cpf);
        public abstract void buildEstado(String estado);
        public abstract void buildStatus(String status);
	
	public UsuarioProduct getUsuario(){
		return usuarioB;
	};

}

