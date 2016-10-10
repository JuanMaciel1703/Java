package AgendadorPokemon;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner read = new Scanner(System.in);
    
    public void menuPrincipal() throws IOException
    { 
        //Aqui sao instanciados os objetos que iram gerenciar o registro de
        //de jogadores e pokemons.
        
        RegistroJogadores regJog = new RegistroJogadores();
        RegistroPokemons regPok = new RegistroPokemons();
       
        Torneio torneio = new Torneio();
        
        Integer resp = 1;
        
        while(resp != 3)
        {
            System.out.println("#=============HOME============#");
            System.out.println("1- CADASTRAR JOGADOR");
            System.out.println("2- AGENDAR TORNEIO");
            System.out.println("3- SAIR");
            System.out.println("#=============================#");

            System.out.printf("RESPOSTA: ");
            resp = Integer.parseInt(read.nextLine());
            

            switch(resp)
            {
                case 1: regJog.cadastro();  break;
                case 2: torneio.Round();    break;
                case 3: break; 
                default: System.out.println("OPÇÃO INVÁLIDA");       break;
            }
        }
    }
}
