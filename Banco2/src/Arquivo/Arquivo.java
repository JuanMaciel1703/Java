package Arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    public void escreve(String texto, int I) throws IOException
    {
        FileWriter arquivo = new FileWriter("./clientes/cliente"+(I+1)+".txt", true);
        BufferedWriter buff = new BufferedWriter(arquivo);
        
        buff.append(texto);
        buff.newLine();
        buff.newLine();

        
        buff.close();
    }
    
    public void escreveArq(String texto, String dir) throws IOException
    {
        FileWriter arquivo = new FileWriter(dir+"\\dados.txt", true);
        BufferedWriter buff = new BufferedWriter(arquivo);
        
        buff.append(texto);
        buff.newLine();
        buff.newLine();

        
        buff.close();
    }
    
    public Pessoas.Funcionario getDados(String arqPessoa) throws IOException
    {
        BufferedReader buffRead = new BufferedReader(new FileReader(arqPessoa));
        
        String linha = "";
        String [] linhas;
        int i = 0;
        
        linhas = new String[6];

        while (buffRead.ready() && i <= 5) {
            linhas[i] = buffRead.readLine();
            i++;
        }
        
        if("Nao possui".equals(linhas[5]))
        {
            Pessoas.Funcionario f = new Pessoas.Funcionario();
            f.setNome(linhas[0]);
            f.setIdade(Integer.parseInt(linhas[1]));
            f.setCpf(linhas[2]);
            f.setEndereco(linhas[3]);
            f.setSalario(Double.parseDouble(linhas[4]));
            
            buffRead.close();
            
            return f;
        }
        else
        {
            Pessoas.Gerente g = new Pessoas.Gerente();
            
            g.setNome(linhas[0]);
            g.setCpf(linhas[1]);
            g.setIdade(Integer.parseInt(linhas[2]));
            g.setEndereco(linhas[3]);
            g.setSalario(Double.parseDouble(linhas[4]));
            g.setSenha(linhas[5]);
            
            buffRead.close();
            
            return g;
        }
    }
}
