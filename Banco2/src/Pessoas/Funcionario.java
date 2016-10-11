package Pessoas;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Funcionario {
    private String  nome;
    private String  cpf;
    private int     idade;
    private String  endereco;
    private String  arquivoPessoal;
    protected double  salario;
    
    public void setaDados(int tipo) throws IOException
    {
        Scanner read = new Scanner(System.in);
        String endereco;
        String dir;
        String mensagemTipo;
        
        if(tipo == 1)
        {
            dir = "C:\\Users\\Juan\\Documents\\NetBeansProjects\\Banco2\\Pessoas\\Funcionarios\\Funcionario\\";
            mensagemTipo = "Funcionario";
        }
        else
        {
            dir = "C:\\Users\\Juan\\Documents\\NetBeansProjects\\Banco2\\Pessoas\\Funcionarios\\Caixa\\";
            mensagemTipo = "Caixa";
        }
        
        System.out.printf("Entre o nome do "+mensagemTipo+": ");
        this.setNome(read.nextLine());

        System.out.printf("Entre o cpf do "+mensagemTipo+": ");
        this.setCpf(read.nextLine());

        System.out.printf("Entre o endereço do "+mensagemTipo+"[OPCIONAL]: ");
        
        endereco = read.nextLine(); 
        if(endereco.equals(""))
            this.setEndereco("Nao tem Endereco");
        else
            this.setEndereco(endereco);
        
        System.out.printf("Entre a idade do "+mensagemTipo+" [OPCIONAL]: ");
        try
        {
            this.setIdade(Integer.parseInt(read.nextLine()));
        }
        catch(Exception e)
        {
            this.setIdade(0);
        }
        
        do
        {
            System.out.printf("Entre o salario do "+mensagemTipo+": ");
            try
            {
                this.setSalario(Double.parseDouble(read.nextLine()));
            }catch(Exception e)
            {
                System.out.println("Valor inválido.");
                this.setSalario(0);
            }
        }
        while(this.getSalario() == 0);
        
        

        File diretorio = new File(dir+this.getNome());
        diretorio.mkdir();

        this.setArquivoPessoal(diretorio.getPath());

        String dados = this.getNome() +"\r\n"+  this.getIdade()+"\r\n"+this.getCpf() +"\r\n"+ this.getEndereco() +"\r\n"+ this.getSalario()+"\r\n"+"\r\n";

        new Arquivo.Arquivo().escreveArq(dados, this.getArquivoPessoal());

        System.out.println("\n");

        System.out.println("Nome: " + this.getNome()+"\nIdade: "+this.getIdade()+"\nEndereco: "+this.getEndereco()+
                            "\nSalario: "+ this.getSalario() + "\nDiretório: "+this.getArquivoPessoal());
        System.out.println("\n");
    }
    
    public double getBonificacao()
    {
        return this.salario * 0.10;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getArquivoPessoal()
    {
        return this.arquivoPessoal;
    }
    
    public void setArquivoPessoal(String dir)
    {
        this.arquivoPessoal = dir;
    }
    
    
}
