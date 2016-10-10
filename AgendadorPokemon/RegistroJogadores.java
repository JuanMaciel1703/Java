package AgendadorPokemon;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class RegistroJogadores {
    Scanner read = new Scanner(System.in);
    
    private Jogador [] jogadores;
    private Integer qtdJogadores;
    private String dirJogador; // Armazena o resgate do diretorio de um jogador
    private int i;
    
    public void cadastro() throws IOException
    {
        System.out.println("Quantos jogadores você deseja cadastrar?");
        qtdJogadores = Integer.parseInt(read.nextLine());
        
        jogadores = new Jogador[qtdJogadores];
        
        for(i = 0; i <= qtdJogadores - 1; i++)
        {
            File file = new File("C:\\Users\\Juan\\Documents\\NetBeansProjects\\AgendadorPokemon\\Jogadores");
            File list[] = file.listFiles(); //Lista todos os arquivos do diretorio descrito no parametro de "File"
            
            jogadores[i] = new Jogador();
            
            jogadores[i].cadastrarJogador((list.length+1)); //list.lenght + 1 define a quantidade
                                                            //de jogadores (diretorios) + o que será adicionado
            
            File diretorio = new File("C:\\Users\\Juan\\Documents\\NetBeansProjects\\AgendadorPokemon\\Jogadores\\"
                            +(list.length+1)+jogadores[i].getNomeJogador());
            //"(list.length+1)+jogadores[i].getNomeJogador()" define primeiramente o numero do jogador e em seguida o nome
            //determinando assim o nome do diretório.
            
            diretorio.mkdir(); //Cria um novo diretório descrito no parametro de File
            
            Arquivo arq = new Arquivo();
            String arqJog = "";
            
            arqJog = jogadores[i].getNomeJogador();
            arq.criaArqJog((list.length+1),arqJog);
            
            RegistroPokemons regPok = new RegistroPokemons();
            dirJogador = diretorio.getPath(); //Atribui a variável o diretório do jogador "i"
            list[i].getPath();
            
            regPok.cadastro(dirJogador, jogadores[i]);
            //Os parâmetros definem para qual jogador(junto ao diretório) 
            //seram adicionados os arquivos dos pokemons.
            
        }
    }
    public void mostraRegistro()
    {
        for(i = 0 ; i <= this.qtdJogadores - 1; i++)
        {
            System.out.println(i+1);
            System.out.println("Nome: "+jogadores[i].getNomeJogador());
            System.out.println("\n");
        }
    }
}
