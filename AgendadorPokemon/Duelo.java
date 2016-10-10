/*package AgendadorPokemon;

public class Duelo {
   int numeroDuelo;
   Jogador jog1, jog2;
   
   
           
   public void efetuarAtaque(Jogador jog1, Jogador jog2)
   {
       int i = 0;
        while(jog1.pokemons[i].getHp() != 0 || jog2.pokemons[i].getHp() != 0)
        {
            //ATAQUE DO POKEMON DO JOGADOR 1
            
            if(jog1.pokemons[i].getTipo() == jog2.pokemons[i].getFraqueza())
                System.out.println("O Ataque foi Efetivo!");
            else
                System.out.println("O Ataque foi Normal.");
            
            int atk1 = jog1.pokemons[i].getCp() - jog2.pokemons[i].getHp();
            
            System.out.println(jog2.pokemons[i].getNomePokemon()+" perdeu "+atk1+" de HP e tem"+jog2.pokemons[i].getHp());
     
            //ATAQUE DO POKEMON DO JOGADOR 2

            if(jog2.pokemons[i].getTipo() == jog1.pokemons[i].getFraqueza())
                System.out.println("O Ataque do Pokemon "+jog2.pokemons[i].getNomePokemon()+" foi Efetivo!");
            else
                System.out.println("O Ataque do Pokemon "+jog2.pokemons[i].getNomePokemon()+" foi Normal.");
            
            int atk2 = jog2.pokemons[i].getCp() - jog1.pokemons[i].getHp();
            
            System.out.println(jog1.pokemons[i].getNomePokemon()+" perdeu "+atk2+" de HP e tem"+jog1.pokemons[i].getHp());
            
            i++;
       }     
   }
}*/
