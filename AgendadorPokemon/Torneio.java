package AgendadorPokemon;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Torneio {
    File file = new File("C:\\Users\\Juan\\Documents\\NetBeansProjects\\AgendadorPokemon\\Jogadores");
    File list[] = file.listFiles();
    
    private Jogador [] jogadores;
    private String pausa;
    
    private int i, qtde_competidores, qtde_competidores_dir, rounds, qtde_competidores_reais, competidor_real_dir, competidor_real;
    private String aux, anterior, proximo;
    
    public void Round()throws IOException
    {
        
        competidor_real_dir = qtde_competidores_dir = qtde_competidores = list.length;
        System.out.println("Qtde Competidores: " + qtde_competidores);
     
        Arquivo arq = new Arquivo();
        
         
       
        qtde_competidores_reais = qtde_competidores;
        competidor_real_dir = competidor_real = qtde_competidores_reais ;
        
        
        
        if (qtde_competidores % 2 == 0)
        {             
            rounds = qtde_competidores - 1;
        }
        else
        {
            rounds = qtde_competidores;
            qtde_competidores += 1; 
        }
        int limite = qtde_competidores/2;
        
        String  [] jogadoresA = new String[limite];
        String  [] jogadoresB = new String[limite];
        
        qtde_competidores += 1;
        
        for (i = 0; i < limite; i++)
        {
            jogadoresA[i] = arq.lerInfoJog(list[i].getPath());
        }
        
        //Preenchendo Vetor A em ordem normal
        for (i = 0; i < limite; i++)
        {
            if (competidor_real % 2 == 0)
            {
                jogadoresB[i] = arq.lerInfoJog(list[qtde_competidores_dir -= 1].getPath());
                //A variavel qtde_competidores_dir foi necessaria para armazenar o valor real
                //da lista, pois se caso fosse usado o qtde_competidores, o decremento seria
                //duplo, sendo assim pulando 1 dos jogadores.
            }
            else
            {
                //Preenchendo Vetor B em ordem inversa
                jogadoresB[i] = arq.lerInfoJog(list[competidor_real_dir -= 1].getPath());
                
                if (i == limite - 1)
                {
                    jogadoresB[i] = "FANTASMA";
                }
            }
                
        }
        
        //Mostrar
        
        for (i = 0; i < limite; i++){
            System.out.printf("" + jogadoresA[i] + "\t");
        }
        System.out.println("\n\n");
        for (i = 0; i < limite; i++){
            System.out.printf("" + jogadoresB[i] + "\t");
        }
        
        //Aqui acontece a organizacao dos vetores girando em sentido horario, 
        //fixando-se a primeira posicao do vetor A
        for (int j = 0; j <= rounds; j++)
        {
            if(j == 0)
            {
                System.out.println("\nRound: "+(j+1));
                this.duelos(j,jogadoresA[0], jogadoresB[0]);
                for(i = 1; i < limite; i++)
                    this.duelos(j,jogadoresA[i], jogadoresB[i]);
                anterior = jogadoresB[0];
                pause();
            }
            else
            {
                anterior = jogadoresB[0];
            }
                
            for (i = 1; i < jogadoresA.length; i++){
               aux = jogadoresA[i];
               jogadoresA[i] = anterior;
               anterior = aux;   
            }    
            
             //Organizando o vetor B
        
            for (i = 0; i < jogadoresB.length; i++){
                if(i < jogadoresB.length - 1){
                    jogadoresB[i] = jogadoresB[i+1];
                }  
                else
                    jogadoresB[i] = aux;
            }
                j++;
                System.out.println("\nRound: "+(j+1));
                for(i = 0; i < limite; i++)
                    this.duelos(j,jogadoresA[i], jogadoresB[i]);
                j--;
                pause();
        }
        System.out.println("\n\n");
    }
    public void duelos(int round, String jog1, String jog2)throws IOException
    {
        Arquivo arq = new Arquivo();
        String arqDuelos = "";
        System.out.println("["+(round+1)+"]\n");
        System.out.println("\n"+jog1+"\t\tVS\t\t"+jog2);
        System.out.println("\n");
        
        arqDuelos += "Round["+(round+1)+"]\r\n\r\n\t" + "\r\n"+jog1+"\t\tVS\t\t"+ jog2 + "\r\n";
       
        
        arq.criaArqTorneio(list.length, arqDuelos);
        
    }
    
    private void pause()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Pressione <ENTER> para continuar...");
        this.pausa = obj.nextLine();
        this.pausa = null;
    }
}
