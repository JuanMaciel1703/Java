package Banco;

import java.util.*;
import java.io.IOException;


public class ContaBancaria {
    Scanner obj = new Scanner(System.in);
    
    private String numeroConta;
    private double saldo;
    private double saldoInvestimento;
    private String titular;
    private double taxaJuros = 0.01;
    
    public void cadastrarConta(String nome, int contI) throws IOException
    {
        Boolean resp;
        
        this.titular = nome;
        System.out.println("Insira o número da conta["+(contI+1)+"]: ");
        numeroConta = obj.nextLine();
        
        System.out.println("Deseja efetuar um depósito? Digite true para SIM ou false para NÃO");
        resp = obj.nextBoolean();
        
        if(resp)
        {
            System.out.printf("Insira o Valor a ser depositado: R$");
            float valor = obj.nextFloat();
            this.efetuarDeposito(valor);
        }
        
    }
    
    public void setSaldo(double valor)
    {
        this.saldo = valor;
    }
   
    public double getSaldo()
    {
        return this.saldo;
    }
    
    public double getSaldoInvestimento()
    {
        return this.saldoInvestimento;
    }
    
    public void setSaldoInvestimento(double valor)
    {
        saldoInvestimento += valor; 
    }
    
    public void setTitular(String titular)
    {
        this.titular = titular;
    }
    
    
    public String getTitular()
    {
        return this.titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
    
    public void criarConta()
    {
        System.out.println("Conta Criada");
    }
    public void consultarSaldo()
    {
        System.out.println("Seu saldo é de R$" + this.saldo +".");
    }
    public void efetuarSaque(double valor)
    {
        
        if(this.saldo < valor)
        {
            System.out.println("Saldo insuficiente!");
        }
        else
        {
            this.saldo = this.saldo - valor;
            System.out.println("Você sacou R$" + valor + " e possui R$" + this.saldo + " de saldo restante");
        }
    }
    public void efetuarDeposito(double valor)
    {
        this.saldo = this.saldo + valor;
        System.out.println("Você depositou R$" + valor + " e possui R$" + this.saldo + " de saldo.");
    }
    public void efetuarTransferencia(double valor)
    {
        System.out.println("Transferencia Efetuada");
    }
    public void calcularRendimento()
    {
        Boolean resp;
        System.out.printf("Deseja calcular um investimento? [Digite 'true' para sim, ou 'false' para não]: ");
        resp = obj.nextBoolean();
            if(resp)
            {
                System.out.println("Insira o valor do investimento: ");
                this.saldoInvestimento = obj.nextDouble();

                System.out.println("Insira a quantidade de messes: ");
                int messes = obj.nextInt();

                /*System.out.println("Insira o Juros: ");
                this.taxaJuros = obj.nextDouble();*/

                double saldoFinal = saldoInvestimento * Math.pow(1 + taxaJuros , messes);

                System.out.println("Seu saldo no final será de " + saldoFinal);
            }
            
        
    }
    
}
