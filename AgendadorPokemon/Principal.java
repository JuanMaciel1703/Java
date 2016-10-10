/*
 * Autores: Juan Lucas Arruda Maciel & Eric dos Santos Dias
 * Data: 08/09/2016
 * Avaliação 1
 */

package AgendadorPokemon;
import java.io.IOException;

public class Principal {
    public String pausa;
    
    public  static void main(String[] args) throws IOException
    {   
        Menu m = new Menu();
       
        //O programa é gerenciado todo a partir do menu.
        
        m.menuPrincipal();
    }
}
