package FactoryMethod; 

public class fabricaSistemas implements FabricaLivros
{
    @Override
    public Livros criaLivros()
    {
        return new java();
        
    }
    
    @Override
    public Livros criaLivros2()
    {
        return new BancoDados();
        
    }
    
}


