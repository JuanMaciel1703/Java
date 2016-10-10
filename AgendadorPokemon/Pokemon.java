package AgendadorPokemon;
import java.util.Scanner;
import java.io.IOException;

public class Pokemon {
    Scanner read = new Scanner(System.in);
       
    private String nomePokemon;
    private Integer cp;
    private Integer hp;
    private String tipo;
    private String fraqueza;
    
    public void cadastrarPokemon(int numPoke, Jogador jog, int qtdPok) throws IOException
    {
        System.out.println("#=====CADASTRO DE POKEMON=====#");
        
        System.out.printf("Insira o nome do Pokemon ["+(numPoke+1)+"]: ");
        this.nomePokemon = read.nextLine();
        
        System.out.printf("Insira o CP do Pokemon ["+(numPoke+1)+"]: ");
        this.cp = Integer.parseInt(read.nextLine());
        
        System.out.printf("Insira o HP do Pokemon ["+(numPoke+1)+"]: ");
        this.hp = Integer.parseInt(read.nextLine());
        
        System.out.println("Selecione o tipo do seu Pokemon");
        System.out.println("1-FOGO  |   2-AGUA  |   3-GRAMA   |   4-ELETRICO    |   5-PEDRA");
        System.out.printf("RESPOSTA: ");
        
        Integer resp = Integer.parseInt(read.nextLine());
        
        switch(resp)
        {
            case 1: this.tipo = "FOGO";     this.fraqueza = "AGUA";         break;
            case 2: this.tipo = "AGUA";     this.fraqueza = "ELETRICO";     break;
            case 3: this.tipo = "GRAMA";    this.fraqueza = "FOGO";         break;
            case 4: this.tipo = "ELETRICO"; this.fraqueza = "PEDRA";        break;
            case 5: this.tipo = "PEDRA";    this.fraqueza = "AGUA";         break;
        }
    }
    public String getTipo()
    {
        return this.tipo;
    }
    
    public String getFraqueza()
    {
        return this.fraqueza;
    }

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFraqueza(String fraqueza) {
        this.fraqueza = fraqueza;
    }
    
    
    
    
}
