package Bean;
/**
 *
 * @author Alberto
 */
public class Usuario{
   public String nome;
   public String endereco;
   public String cidade;
   public String estado;
   public String telCelular;
   public String cpf;
   private String status;
  
        
    public Usuario(String nome, String endereco, String cidade, String estado, String telefone, String cpf, String status) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telCelular = telCelular;
        this.status = status;
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

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

   /* public void buildNome(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buildEndereco(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buildCidade(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buildtelCelular(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buildCpf(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buildEstado(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
