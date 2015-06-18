package builder;

/**
 *
 * @author Ana Catarina
 */
 

public class ProfessorBuilder extends UsuarioBuilder {
		@Override
		public void buildNome() {
			usuarioB.nome = "Paulo";
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
