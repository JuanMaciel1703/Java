package Banco;

import Pessoas.Caixa;
import java.io.File;
import java.io.IOException;

import Pessoas.Funcionario;
import Pessoas.Gerente;

public class Calculo {
    float soma;
    
    Pessoas.Funcionario [] funcionarios;
    Pessoas.Gerente [] gerentes;
    Pessoas.Caixa [] caixas;
    
    public void somaBonificacoes(Funcionario f)
    {
        this.soma += f.getBonificacao();
    }
    
    public void resgataFuncionarios() throws IOException
    {
        int qtdF, qtdG, qtdC, i;
        String dirF, dirG, dirC;
        
        //Resgata o caminho das pastas dos tipos de funcionarios
        
        dirF = "C:\\Users\\Juan\\Documents\\NetBeansProjects\\Banco2\\Pessoas\\Funcionarios\\Funcionario\\";
        dirG = "C:\\Users\\Juan\\Documents\\NetBeansProjects\\Banco2\\Pessoas\\Funcionarios\\Gerente\\";
        dirC = "C:\\Users\\Juan\\Documents\\NetBeansProjects\\Banco2\\Pessoas\\Funcionarios\\Caixa\\";
        
        //Resgate da quantidade de pastas dentro de cada pasta de cada tipo de funcionario
        File fileF = new File(dirF);
        File listF[] = fileF.listFiles();
        
        qtdF = listF.length;
        
        File fileG = new File(dirG);
        File listG[] = fileG.listFiles();
        
        qtdG = listG.length;
        
        File fileC = new File(dirC);
        File listC[] = fileC.listFiles();
        qtdC = listC.length;
        
        //Reservando o tamanho de cada um dos funcioanrios na memória
        
        funcionarios = new Pessoas.Funcionario[qtdF];
        gerentes = new Pessoas.Gerente[qtdG];
        caixas = new Pessoas.Caixa[qtdC];
        
        //Resgate de cada funcionario por tipo
            //Funcionario
        
        for(i = 0; i < qtdF; i++)
        {
            File file = new File(dirF);
            File list[] = file.listFiles();
            
            funcionarios[i] = new Pessoas.Funcionario();
            
            funcionarios[i] = new Arquivo.Arquivo().getDados(list[i].getPath()+"\\dados.txt");    
            
            //System.out.println("Nome: "+funcionarios[i].getNome()+"\nSalario: "+funcionarios[i].getSalario());
            
            this.somaBonificacoes(funcionarios[i]);
        }
        
        for(i = 0; i < qtdG; i++)
        {
            File file = new File(dirG);
            File list[] = file.listFiles();
            
            gerentes[i] = new Pessoas.Gerente();
            
            gerentes[i] = (Gerente) new Arquivo.Arquivo().getDados(list[i].getPath()+"\\dados.txt");   
            
            //System.out.println("Nome: "+gerentes[i].getNome()+"\nSalario: "+gerentes[i].getSalario()+"\nSenha: "+gerentes[i].getSenha());
            
            this.somaBonificacoes(gerentes[i]);
        }
        
        for(i = 0; i < qtdC; i++)
        {
            File file = new File(dirC);
            File list[] = file.listFiles();
            
            caixas[i] = new Pessoas.Caixa();
            
            caixas[i] = (Caixa) new Arquivo.Arquivo().getDados(list[i].getPath()+"\\dados.txt");      
            
            //System.out.println("Nome: "+caixas[i].getNome()+"\nSalario: "+caixas[i].getSalario());
            
            this.somaBonificacoes(caixas[i]);
        }
        
        System.out.println(this.soma);
        
        
    }
}
