package Registros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RegistroPessoas {
    Scanner read = new Scanner(System.in);
    int qtdFunc,qtdGer, qtdCaix, i;
    
    Pessoas.Funcionario [] funcionarios;
    Pessoas.Gerente [] gerentes;
    Pessoas.Caixa [] caixas;
    
    public void cadFuncionario() throws IOException
    {   
        do
        {
            System.out.printf("Quantos Funcionários você deseja cadastrar? : ");
            try
            {
                qtdFunc = Integer.parseInt(read.nextLine());
            }catch(Exception e)
            {
                System.out.println("Entre um NÚMERO.");
                qtdFunc = 0;
            }
        }
        while(qtdFunc == 0);
        
        funcionarios = new Pessoas.Funcionario[qtdFunc];
        
        for(i = 0; i < qtdFunc; i++)
        {
            funcionarios[i] = new Pessoas.Funcionario();
            funcionarios[i].setaDados(1);
        }   
    }
    
    public void cadGerente() throws IOException
    {
        do
        {
            System.out.printf("Quantos Gerentes você deseja cadastrar? : ");
            try
            {
                qtdGer = Integer.parseInt(read.nextLine());
            }catch(Exception e)
            {
                System.out.println("Entre um NÚMERO.");
                qtdGer = 0;
            }
        }
        while(qtdGer == 0);
        
        
        gerentes = new Pessoas.Gerente[qtdGer];
        
        for(i = 0; i < qtdGer; i++)
        {
            gerentes[i] = new Pessoas.Gerente();
            
            gerentes[i].setaDados(0);
        }  
    }
    
    public void cadCaixa() throws IOException
    {   
        do
        {
            System.out.printf("Quantos Caixas você deseja cadastrar? : ");
            try
            {
                qtdCaix = Integer.parseInt(read.nextLine());
            }catch(Exception e)
            {
                System.out.println("Entre um NÚMERO.");
                qtdCaix = 0;
            }
        }
        while(qtdCaix == 0);
        
        caixas = new Pessoas.Caixa[qtdCaix];
        
        for(i = 0; i < qtdCaix; i++)
        {
            caixas[i] = new Pessoas.Caixa();
            
            caixas[i].setaDados(2);
        }   
    }
    
}
