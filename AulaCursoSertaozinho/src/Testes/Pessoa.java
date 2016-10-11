package Testes;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }
    
    public void setIdade(int idade)
    {
        this.idade = idade;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getSobrenome()
    {
        return this.sobrenome;
    }
    
    public int getIdade()
    {
        return this.idade;
    }
    
    public String toString()
    {
        String msg = this.nome +" "+ this.sobrenome +" : "+ this.idade;
        
        return msg;
    }
    
}
