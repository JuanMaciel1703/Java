import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;

public class Menu {
    Scanner read = new Scanner(System.in);
    
    Integer resp = 1;
    
    public void menuPrincipal() throws IOException
    {    
        Banco.Calculo calculo = new Banco.Calculo();
        
        while(resp != 6)
        {
            System.out.println("#=============HOME============#");
            System.out.println("1- CADASTRAR FUNCIONÁRIO");
            System.out.println("2- CADASTRAR GERENTE");
            System.out.println("3- CADASTRAR CAIXA");
            System.out.println("4- CADASTRAR CLIENTE");
            System.out.println("5- CALCULAR SOMA BONIFICAÇÃO");
            System.out.println("6- SAIR");
            System.out.println("#=============================#");

            System.out.printf("RESPOSTA: ");
            resp = Integer.parseInt(read.nextLine());
            

            switch(resp)
            {
                case 1: new Registros.RegistroPessoas().cadFuncionario();   break;
                case 2: new Registros.RegistroPessoas().cadGerente();       break;
                case 3: new Registros.RegistroPessoas().cadCaixa();         break;
                case 4: new Registros.RegistroDeContas().Cadastro();        break;
                case 5: calculo.resgataFuncionarios();         break;
                case 6: break;
                default: System.out.println("OPÇÃO INVÁLIDA");       break;
            }
        }
    }
    
    public void menuCadastro() throws IOException
    {
        Integer R;
        
        System.out.println("#=============HOME============#");
        System.out.println("1- CADASTRAR FUNCIONÁRIO");
        System.out.println("2- CADASTRAR GERENTE");
        System.out.println("3- CADASTRAR CAIXA");
        System.out.println("4- SAIR");
        System.out.println("#=============================#");
        
        System.out.println("Opção: ");
        R = Integer.parseInt(read.nextLine());
        
        Pessoas.Funcionario f = this.getCadastro(R);

        f.setaDados(R);
        
        System.out.println("Nome: "+f.getNome()+"\nIdade: "+f.getIdade());
        
      
    }
    
    public Pessoas.Funcionario getCadastro(Integer n)
    {
        switch(n)
        {
            case 1: return new Pessoas.Funcionario();
            case 2: return new Pessoas.Gerente();
            case 3: return new Pessoas.Caixa();
            
        }
        return new Pessoas.Funcionario();
    }
}
