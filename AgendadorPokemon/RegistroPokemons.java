package AgendadorPokemon;

import java.util.Scanner;
import java.io.IOException;

public class RegistroPokemons {
    String pausa;
    Scanner read = new Scanner(System.in);
       
    private Pokemon [] pokemons;
    private Integer qtdPokemons;
    private Integer totalPokemons;
    private int i;
    
    public void cadastro(String dirJogador, Jogador jogador) throws IOException
    {
        do
        {
            System.out.println("Quantos pokemons você deseja cadastrar?(Até no máximo 6)");
            qtdPokemons = Integer.parseInt(read.nextLine());
            if(qtdPokemons > 6 || qtdPokemons <= 0)
            {
                System.out.println("Erro");
                pause();    
            }
        }
        while(!(qtdPokemons <= 6 && qtdPokemons >= 1));
                
        pokemons = new Pokemon[qtdPokemons];
        
        for(i = 0; i <= qtdPokemons - 1; i++)
        {
            pokemons[i] = new Pokemon();
            
            pokemons[i].cadastrarPokemon(i, jogador, qtdPokemons);            
            
            String regPok   = pokemons[i].getCp()+
                              "\r\n"+pokemons[i].getHp()+"\r\n"
                              +pokemons[i].getTipo()+"\r\n"+pokemons[i].getFraqueza()+"\r\n";
            
            Arquivo arq = new Arquivo();
            arq.escreve(dirJogador, regPok,jogador.getNomeJogador(), pokemons[i].getNomePokemon());
        }
    }
    
     public void mostraRegistro()
    {
        for(i = 0 ; i <= this.qtdPokemons - 1; i++)
        {
            System.out.println(i+1);
            System.out.println("Nome: "+pokemons[i].getNomePokemon());
            System.out.println("HP: "+pokemons[i].getHp());
            System.out.println("CP: "+pokemons[i].getCp());
            System.out.println("Tipo: "+pokemons[i].getTipo()+"   | Fraqueza: "+pokemons[i].getFraqueza());
            pause();  
        }
    }
     private void pause()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Pressione <ENTER> para continuar...");
        this.pausa = obj.nextLine();
        this.pausa = null;
    }
}
