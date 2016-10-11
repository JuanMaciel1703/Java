package Registros;

import Arquivo.Arquivo;
import Pessoas.ClienteBanco;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RegistroDeContas {
    Scanner read = new Scanner(System.in);
    Integer qtdClientes;
    int I, J;
   
    ClienteBanco[] Clientes;
            
   public void Cadastro() throws IOException
   {
     
      
      System.out.printf("Quantos Clientes você deseja cadastrar?  Resposta:  ");
      qtdClientes = Integer.parseInt(read.nextLine());
      
      Clientes = new ClienteBanco[qtdClientes];
      
      for(I = 0; I <= qtdClientes - 1; I++)
      {
          Clientes[I] = new ClienteBanco();
          
          Clientes[I].cadastrarCliente(I);
      }
      
      
   }
   
   public void MostrarLista() 
   {
       for(I = 0; I <= this.qtdClientes - 1; I++)
       {
           System.out.println("----------------------------"+(I+1)+"---------------------------------");
           System.out.println("Cliente : " + Clientes[I].getNomeCliente());
           System.out.println("Data Nascimento : " + Clientes[I].getDataNascimento());
           
           for(J = 0; J <= Clientes[I].getQtdContas() - 1; J++)
           {
                System.out.println("----------------------------"+(J+1)+"---------------------------------");
                System.out.println("Numero da Conta : " + Clientes[I].getConta(J).getNumeroConta());
                System.out.println("Titular : " + Clientes[I].getConta(J).getTitular());
                System.out.println("Agência : " + Clientes[I].getAgencia());
           } 
       }
   }
   public void MostraArquivo() throws IOException
   {
       Arquivo arq = new Arquivo();
       
       for(int I = 0; I <= this.qtdClientes - 1; I++)
       {
           //arq.leitor(I);
       }
       
   }
   
   
}
