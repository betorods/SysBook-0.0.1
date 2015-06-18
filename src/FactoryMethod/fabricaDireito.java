package FactoryMethod;

public class fabricaDireito implements FabricaLivros
{
    @Override
    public Livros criaLivros()
    {
        return new intitulacao();
        
    }
    
    @Override
    public Livros criaLivros2()
    {
        return new processo();
        
    }
}