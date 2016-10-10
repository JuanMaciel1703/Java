package AgendadorPokemon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivo {
  
    public void escreve(String dirJogador, String texto, String nomeJog, String nomePoke) throws IOException
    {
        //Insere no arquivo de texto as informações do pokemon cadastrado diretamente
        //no diretório do jogador definido pelo parametro.
        
        FileWriter arquivo = new FileWriter(dirJogador+"/"+nomePoke+".txt", true);
        BufferedWriter buff = new BufferedWriter(arquivo);
        
        buff.append(texto);
        buff.newLine();
        buff.newLine();

        
        buff.close();
    }
    
    public void criaArqJog(int i, String nomeJog) throws IOException
    {
        //Cria o arquivo com as informações do jogador. O nome do arquivo é definido
        //como (1dados+nomedojogador) pois quando  acontecer o torneio, o resgate do
        //nome do usuário é feito a partir do primeiro arquivo do diretório, logo, o
        //arquivo de dados deve conter na inicial um caractere que deixe-o sempre no
        //inicio.
        
        FileWriter arquivo = new FileWriter("./Jogadores/"+i+nomeJog+"/1dados"+nomeJog+".txt");
        BufferedWriter buff = new BufferedWriter(arquivo);
        
        buff.append(nomeJog);
        buff.newLine();
        buff.newLine();

        
        buff.close();
    }
         
    public void lerInfoPoke(String dirJog, String nomePoke, Pokemon poke) throws IOException
    {
        //Armazena num objeto do tipo Pokemon todas as linhas resgatadas do arquivo de pokemons
        //de um determinado jogador. Essas informações são
        //      linha[0] = HP
        //      linha[1] = CP
        //      linha[2] = Tipo
        //      linha[3] = Fraqueza
        
        File file = new File(dirJog);
        File list[] = file.listFiles();
        
        BufferedReader buffRead = new BufferedReader(new FileReader(dirJog+"/"+list[0].getName()));
        String linha = "";
        String [] linhas;
        int i = 0;

        linhas = new String[4];

        while (buffRead.ready() && i <= 3) {
            linhas[i] = buffRead.readLine();
            i++;
        }
        poke.setNomePokemon(list[0].getName());
        poke.setCp(Integer.parseInt(linhas[0]));
        poke.setHp(Integer.parseInt(linhas[1]));
        poke.setTipo(linhas[2]);
        poke.setFraqueza(linhas[3]);
        
        System.out.println("Nome: "+poke.getNomePokemon()+"\nCP: "+poke.getCp()+"\nHP: "+poke.getHp()+"\nTipo: "+poke.getTipo()+"\nFraqueza: "+poke.getFraqueza());
        
        buffRead.close();
    }
    
    public String lerInfoJog(String dirJog) throws IOException
    {
        //Retorna o nome do jogador que está no arquivo ("dados"+nomedojogador).
        //Este valor fica armazenado na primeira linha do arquivo, logo,
        //ao utilizar o return linhas[0], somente o primeiro valor é retornado.
        //Caso seja do interesse do programador, é possível adicionar outras informações
        //do jogador, e ao resgatar, basta definir um indice desejado e um cast caso
        //necessário.
        
        File file = new File(dirJog);
        File list[] = file.listFiles();
        
        BufferedReader buffRead = new BufferedReader(new FileReader(dirJog+"/"+list[0].getName()));
        String linha = "";
        String [] linhas;
        int i = 0;

        linhas = new String[2];

        while (buffRead.ready() && i < 2) {
            linhas[i] = buffRead.readLine(); //Cada indice recebe uma linha do arquivo
            i++;
        }
        
        buffRead.close();
        return linhas[0];
    }
    
    public void criaArqTorneio(int nomeTorneio, String texto) throws IOException
    {
        //Este método serve para criar um arquivo com o registro dos duelos executados com um número "N"
        //de competidores. O nome do arquivo é definido por esse valor "N". 
        //A ideia inicial era utilizar a data e hora atual para gerar o nome do arquivo, mas, não consegui
        //realizar esta operação.
        
        FileWriter arquivo = new FileWriter("./Torneios/"+nomeTorneio+".txt", true);
        BufferedWriter buff = new BufferedWriter(arquivo);
        
        buff.append(texto);
        buff.newLine();
                
        buff.close();
    }
}
