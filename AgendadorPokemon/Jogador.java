package AgendadorPokemon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

public class Jogador {
    Scanner read = new Scanner(System.in);
    
    private String nomeJogador;
    private Pokemon [] pokemons;
    
    public void cadastrarJogador(int numJog) throws IOException
    {
        System.out.println("#=====CADASTRO DE JOGADOR=====#");
        
        System.out.printf("Insira o nome do jogador ["+(numJog+1)+"]: ");
        
        this.nomeJogador = read.nextLine();
    }

    public String getNomeJogador() {
        return nomeJogador;
    }
}
