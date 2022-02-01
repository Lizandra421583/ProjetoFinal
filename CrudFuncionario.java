package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudFuncionario
{
    //cria o objeto do tipo conexão
    private Connection conexao;
    public CrudFuncionario(Connection conexao){
        this.conexao = conexao;
    }
    
    //Se usar o codigo assim: crud.create(1234567896, "Maria de Fátima")
    // se usa esse "create"
    public boolean create(String nome, String funcao){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Funcionario VALUES('"+nome+"', '"+funcao+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    //Se usar o codigo assim: Funcionario f = new Funcionario(nome, funcao);
    //                        crud.create(f);                     ;
    // se usa esse outro "create"
    public boolean create(Funcionario funcionario){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Funcionario VALUES('"+funcionario.getNome()+"', '"+funcionario.getFuncao()+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean read(String funcao){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Funcionario WHERE funcao = '"+funcao+"'");

            //ResultSet rs = statement.executeQuery("SELECT * FROM Funcionario");
            
            System.out.println("nome - funcao");
            while (rs.next()) {
                String nome = rs.getString("nome");
                String func = rs.getString("funcao");
                
                System.out.println(nome+ " - " + func);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(String nome, String novaFuncao){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Funcionario SET funcao ='"+novaFuncao+"' WHERE nome = '"+nome+"'");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(String nome){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Funcionario WHERE nome ='"+nome+"'");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
