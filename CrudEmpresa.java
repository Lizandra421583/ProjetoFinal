package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudEmpresa
{
    private Connection conexao;
    public CrudEmpresa(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean create(String razaosocial, String cnpj, String endereco, String telefone){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO DadosEmpresa VALUES('"+razaosocial+"', "+cnpj+", '"+endereco+"',"+telefone+")");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean create(Empresa empresa){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO DadosEmpresa VALUES('"+empresa.getRazaosocial()+"', "+empresa.getCnpj()+", '"+empresa.getEndereco()+"',"+empresa.getTelefone()+")");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean read(String rzs){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM DadosEmpresa WHERE razaosocial = '"+rzs+"'");

            //ResultSet rs = statement.executeQuery("SELECT * FROM DadosEmpresa");
            
            System.out.println("razaosocial - cnpj - endereco - telefone");
            while (rs.next()) {
                int cnpj = rs.getInt("cnpj");
                String endereco = rs.getString("endereco");
                int telefone = rs.getInt("telefone");
                
                System.out.println( rzs+ " - " +cnpj+ " - " +endereco+ " - " +telefone);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(String cnpj, String novoEndereco){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE DadosEmpresa SET endereco ='"+novoEndereco+"' WHERE cnpj ='"+cnpj+"'");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(String cnpj){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM DadosEmpresa WHERE cnpj ="+cnpj+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
