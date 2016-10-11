package Pessoas;

import Arquivo.Arquivo;
import Banco.ContaBancaria;
import java.util.*;
import java.io.IOException;

public class ClienteBanco {
    Scanner obj = new Scanner(System.in);
    
    private String nomeCliente;
    private String cpfCliente;
    private int dataNascimento;
    private String[] endereco;
    private int qtdEndereco;
    private String nomeMae;
    private String nomePai;
    private String senha;
    
    private int agencia;
    private ContaBancaria[] Contas;
    private int qtdContas;
    
    public void cadastrarCliente(int cliI) throws IOException
    {
        Arquivo arq = new Arquivo();
        String regArq = "";
        String regEnd = "";
        String regContas = "";
        String regGeral = "";
         
        
        Boolean R;
        
        System.out.printf("Insira o nome do cliente ["+(cliI+1)+"]: ");
        this.nomeCliente = obj.nextLine(); 
        System.out.printf("Insira o CPF: ");
        this.cpfCliente = obj.nextLine();
        System.out.printf("Insira a data de nascimento: ");
        this.dataNascimento = Integer.parseInt(obj.nextLine());
        //System.out.printf("Insira o nome da Mãe: ");
        //this.nomeMae = obj.nextLine();
        //System.out.printf("Insira o nome do Pai: ");
        //this.nomePai = obj.nextLine();


        System.out.println("Quantos endereços você tem?");
        this.qtdEndereco = Integer.parseInt(obj.nextLine());
        endereco = new String[qtdEndereco];

        this.cadastrarEndereco();

        System.out.printf("Insira a Senha: ");
        this.senha = obj.nextLine();
        
        System.out.printf("Insira a Agência: ");
        this.agencia = obj.nextInt();
        
        System.out.printf("Quantas contas você deseja cadastrar? Resposta: ");
        qtdContas = obj.nextInt();
            
        Contas = new ContaBancaria[qtdContas];
            
        for(int I = 0 ; I<= qtdContas -1 ; I++)
        {
            Contas[I] = new ContaBancaria();
            Contas[I].cadastrarConta(this.nomeCliente, I);
                
            Contas[I].calcularRendimento();
        }
        
        regArq = "Nome: " + this.nomeCliente + "\r\nCPF: " + this.cpfCliente + "\r\nData Nascimento: " 
                  + this.dataNascimento + "\r\nAgência: " + this.agencia;
            
        regGeral = regArq;
            
        for(int I = 0; I <= this.qtdEndereco - 1; I++)
        {
            regEnd = "\r\n  Endereço"+(I+1)+": "+this.endereco[I];
            regGeral += regEnd;
        }
        
        for(int I = 0; I<= this.qtdContas - 1; I++)
        {
            regContas = "\r\n       Número da Conta["+(I+1)+"]: "+this.Contas[I].getNumeroConta()+
                        "\r\n         Saldo: R$ "+this.Contas[I].getSaldo();
            regGeral += regContas;
        }
        
        arq.escreve(regGeral, cliI);  
    }

    public ContaBancaria getConta(int J) {
        return Contas[J];
    }

    public int getQtdContas() {
        return qtdContas;
    }

    public void setQtdContas(Integer qtdContas) {
        this.qtdContas = qtdContas;
    }
    
    public void cadastrarEndereco()
    {
      int I;
      
      for(I = 0; I <= this.qtdEndereco - 1;I++)
      {
       endereco[I] = new String();
       System.out.println("Insira o endereço " + (I+1) + " ");
       endereco[I] = obj.nextLine();
      }
    }

    public Integer getQtdEndereco() {
        return qtdEndereco;
    }
    
    public String[] getEndereco() {
        return endereco;
    }
    
    //Fim Exercício 17/08/2016
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getSenha() {
        return senha;
    }

    public int getAgencia() {
        return agencia;
    }
    
    
    
    public void alterarDados()
    {
        System.out.println("Alterar Dados");
    }
}
