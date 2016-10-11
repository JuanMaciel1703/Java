package Pessoas;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Gerente extends Funcionario {
    private String senha;
    
    public void login(String entrada)
    {
        if(entrada.equals(this.getSenha()))
        {
            System.out.println("Bem-Vindo "+this.getNome()+" !");
        }
        else
        {
            System.out.println("Senha Incorreta, tente novamente");
        }
    }
    
    public void setaDados(int n) throws IOException
    {
        Scanner read = new Scanner(System.in);
        String endereco;
        String senha;
        
        System.out.printf("Entre o nome do Gerente: ");
        this.setNome(read.nextLine());

        System.out.printf("Entre a senha do Gerente[OPCIONAL]: ");
        senha = read.nextLine();
        if(senha.equals(""))
            this.setEndereco("Nao tem Senha");
        else
            this.setSenha(senha);

        System.out.printf("Entre o cpf do Gerente: ");
        this.setCpf(read.nextLine());

        System.out.printf("Entre o endereço do Gerente [OPCIONAL]: ");
        endereco = read.nextLine(); 
        if(endereco.equals(""))
            this.setEndereco("Nao tem Endereco");
        else
            this.setEndereco(endereco);
        
        System.out.printf("Entre a idade do Gerente [OPCIONAL]: ");
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
            System.out.printf("Entre o salario do Gerente: ");
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

        File diretorio = new File("C:\\Users\\Juan\\Documents\\NetBeansProjects\\Banco2\\Pessoas\\Funcionarios\\Gerente\\"+this.getNome());
        diretorio.mkdir();

        this.setArquivoPessoal(diretorio.getPath());

        String dados = this.getNome() +"\r\n"+  this.getIdade()+"\r\n"+this.getCpf() +"\r\n"+ this.getEndereco() +"\r\n"+ this.getSalario()+"\r\n"+this.getSenha();

        new Arquivo.Arquivo().escreveArq(dados, this.getArquivoPessoal());

        System.out.println("\n");

        System.out.println("Nome: " + this.getNome()+"\nIdade: "+this.getIdade()+"\nEndereco: "+this.getEndereco()+
                            "\nSalario: "+ this.getSalario() + "\nDiretório: "+this.getArquivoPessoal());
        System.out.println("\n");
    }
    
    public double getBonificacao()
    {
        return this.salario * 0.15;
    }
    
    public void setSenha(String senha)
    {
        this.senha = senha;
    }
    
    public String getSenha()
    {
        return senha;
    }
}
