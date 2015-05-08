package Bean;
/**
 *
 * @author Alberto
 */
public class Usuario
{
   private String nome;
   private String endereco;
   private String cidade;
   private String estado;
   private String telefone;
   private String cpf;
  
        
    public Usuario(String nome, String endereco, String cidade, String estado, String telefone, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        
    } 
    public Usuario(){
    
    }

    
   public String getNome()
   {
       return nome;
   }
   
   public void setNome(String nome)
   {
      this.nome = nome;
   }
    
   public String getEndereco()
   {
       return endereco;
   }
   
   public void setEndereco(String endereco)
   {
      this.endereco = endereco;
   }
    
   public String getCidade()
   {
       return cidade;
   }
   
   public void setCidade(String cidade)
   {
      this.cidade = cidade;
   }
  
   public String getEstado()
   {
       return estado;
   }
   
   public void setEstado(String estado)
   {
      this.estado = estado;
   }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
