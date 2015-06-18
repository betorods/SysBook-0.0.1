package builder;

//import Bean.Usuario;
import javax.swing.JOptionPane;

public class AlunoBuilder extends UsuarioBuilder {
    
    
                @Override
		public void buildNome() {
                   
			usuarioB.nome = "Alberto";
                       
		}

		@Override
		public void buildEndereco(String endereco) {
			usuarioB.endereco = endereco;
		}

		@Override
		public void buildCidade(String cidade) {
			usuarioB.cidade = cidade;
		}

		@Override
		public void buildTelCelular(String telCelular) {
			usuarioB.telCelular = telCelular;
		}
		
		@Override
		public void buildCpf(String cpf) {
			usuarioB.cpf = cpf;
		}
		
                @Override
		public void buildEstado(String estado) {
			usuarioB.estado = estado;
		}
                
                @Override
		public void buildStatus(String status) {
			usuarioB.status = status;
		}

            
}

