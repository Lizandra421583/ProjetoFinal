// ---------------------------------------------------------------- //
// Membro da Equipe: Lizandra Farias de Oliveira (Matrícula:421583) //
// ---------------------------------------------------------------- //

package Conexao;

import Conexao.TestConexaoSqlite3;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

import Conexao.CrudCliente;
import Conexao.CrudEmpresa;
import Conexao.CrudFuncionario;
import Conexao.CrudProdutos;

public class Main{
    public static void main(String args[])throws Exception{
        Scanner teclado = new Scanner(System.in);
        System.out.println("Deseja fazer edição em qual tabela? \n 1 - Cliente \n 2 - Dados.da.Empresa \n 3 - Funcionario \n 4 - Produtos");
        int tab = teclado.nextInt();
        
        TestConexaoSqlite3 conexao = new TestConexaoSqlite3();
        conexao.abrirConexao();
        
        // -------------------------//
        // Edição na tabela Cliente //
        // -------------------------//
        
        if(tab == 1){
            Scanner t1 = new Scanner(System.in);
            System.out.println("O que você deseja fazer nesta tabela? \n 1 - Inserir; \n 2 - Selecionar; \n 3 - Alterar; \n 4 - Deletar.");
            int a = t1.nextInt();
            
            CrudCliente crud = new CrudCliente(conexao.getConnection());
            
            if(a == 1) {
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite os dados que deseja inserir na tabela.");
                System.out.println("Nome (pode ser NULL):");
                String nome = t2.next(); 
                System.out.println("Endereço (pode ser NULL):");
                String endereco = t2.next();
                Scanner t3 = new Scanner(System.in);
                System.out.println("Telefone:");
                String telefone = t3.next();
                System.out.println("Data da Compra:");
                String data = t3.next();
                Scanner t4 = new Scanner(System.in);
                System.out.println("Código do Produto Comprado (FK):");
                String produto = t4.next();
                System.out.println("Forma de Pagamento:");
                String pagamento = t4.next();
            
                Cliente c = new Cliente(nome,endereco,telefone, data, produto, pagamento);
            
                System.out.println(crud.create(c));
                crud.create(c);
            }
            
            if(a == 2) {
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite o telefone que deseja selecionar na tabela.");
                String telefone = t2.next();
                
                crud.read(telefone);
            }
            
            if(a == 3) {
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite as informações abaixo para a alteração requerida.");
                System.out.println("Telefone:");
                String telefone = t2.next();
                System.out.println("Novo endereço do cliente (sem espaços):");
                String novoEnd = t2.next();
                
                System.out.println(crud.update(telefone, novoEnd));
            }
            
            if(a == 4){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite o telefone a ser deletado.");
                String telefone = t2.next();
                
                System.out.println(crud.delete(telefone));
            }
        }
        
        // ------------------------------//
        // Edição na tabela DadosEmpresa //
        // ------------------------------//
        
        if(tab == 2){
            Scanner t1 = new Scanner(System.in);
            System.out.println("O que você deseja fazer nesta tabela? \n 1 - Inserir; \n 2 - Selecionar; \n 3 - Alterar; \n 4 - Deletar.");
            int a = t1.nextInt();
            
            CrudEmpresa crud = new CrudEmpresa(conexao.getConnection());
            
            if(a == 1){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite os dados que deseja inserir na tabela.");
                System.out.println("Razão Social:");
                String razaosocial = t2.next();
                Scanner t3 = new Scanner(System.in);
                System.out.println("CNPJ (PK):");
                String cnpj = t3.next();
                System.out.println("Endereço (pode ser NULL):");
                String endereco = t3.next();
                Scanner t4 = new Scanner(System.in);
                System.out.println("Telefone (pode ser NULL):");
                String telefone = t4.next();
                
                Empresa e = new Empresa(razaosocial,cnpj,endereco,telefone);
                System.out.println(crud.create(e));
                
                //System.out.print(crud.create(razaosocial,cnpj,endereco,telefone));
            }
            
            if(a == 2){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite a razão social que deseja selecionar na tabela.");
                String rzs = t2.next();
                
                crud.read(rzs);
            }
            
            if(a == 3){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite as informações abaixo para a alteração requerida.");
                System.out.println("CNPJ:");
                String cnpj = t2.next();
                System.out.println("Novo endereço da empresa (sem espaços):");
                String novoEnd = t2.next();
                
                System.out.println(crud.update(cnpj, novoEnd));
            }
            
            if(a == 4){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite o CNPJ a ser deletado.");
                String cnpj = t2.next();
                
                System.out.println(crud.delete(cnpj));
            }
        }
        
        // -----------------------------//
        // Edição na tabela Funcionario //
        // -----------------------------//
        
        if(tab == 3){
            Scanner t1 = new Scanner(System.in);
            System.out.println("O que você deseja fazer nesta tabela? \n 1 - Inserir; \n 2 - Selecionar; \n 3 - Alterar; \n 4 - Deletar.");
            int a = t1.nextInt();
            
            CrudFuncionario crud = new CrudFuncionario(conexao.getConnection());
            
            if(a == 1){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite os dados que deseja inserir na tabela.");
                System.out.println("Nome Completo:");
                String nome = t2.next();
                Scanner t3 = new Scanner(System.in);
                System.out.println("Função:");
                String funcao = t3.next();
            
                Funcionario f = new Funcionario(nome, funcao);
                System.out.println(crud.create(f));
                
                //System.out.print(crud.create(nome, funcao));
            }
            
            if(a == 2){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite a função dos empregados que deseja selecionar na tabela.");
                String funcao = t2.next();
                
                crud.read(funcao);
            }
            
            if(a == 3){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite as informações abaixo para a alteração requerida.");
                System.out.println("Nome do Funcionário:");
                String nome = t2.next();
                System.out.println("Nova função a ser exercida (sem espaços):");
                String novaFuncao = t2.next();
                
                System.out.println(crud.update(nome, novaFuncao));
            }
            
            if(a == 4){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite o nome do funcionário a ser deletado.");
                String nome = t2.next();
                
                System.out.println(crud.delete(nome));
            }
        }
        
        // --------------------------//
        // Edição na tabela Produtos //
        // --------------------------//
        
        if(tab == 4){
            Scanner t1 = new Scanner(System.in);
            System.out.println("O que você deseja fazer nesta tabela? \n 1 - Inserir; \n 2 - Selecionar; \n 3 - Alterar; \n 4 - Deletar.");
            int a = t1.nextInt();
            
            CrudProdutos crud = new CrudProdutos(conexao.getConnection());
            
            if(a == 1){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite os dados que deseja inserir na tabela.");
                System.out.println("Nome do Produto:");
                String nome = t2.next();
                Scanner t3 = new Scanner(System.in);
                System.out.println("Classificação do Produto:");
                String classe = t3.next();
            
                Produtos p = new Produtos(nome, classe);
                System.out.println(crud.create(p));
                
                //System.out.print(crud.create(nome, classe));
            }
            
            if(a == 2){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite a classificação dos dados que deseja selecionar na tabela.");
                String classe = t2.next();
                
                crud.read(classe);
            }
            
            if(a == 3){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite as informações abaixo para a alteração requerida.");
                System.out.println("Código do produto:");
                int cod = t2.nextInt();
                System.out.println("Novo nome (sem espaços):");
                String novonome = t2.next();
                
                System.out.println(crud.update(cod, novonome));
            }
            
            if(a == 4){
                Scanner t2 = new Scanner(System.in);
                System.out.println("Digite o código do produto a ser deletado.");
                int cod = t2.nextInt();
                
                System.out.println(crud.delete(cod));
            }
        }
        
        
        conexao.fecharConexao();     
    }
}