package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudProdutos
{
    private Connection conexao;
    public CrudProdutos(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean create(String nome, String classificacao){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Produtos (nome, classificacao) VALUES('"+nome+"', '"+classificacao+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean create(Produtos produtos){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Produtos (nome, classificacao) VALUES('"+produtos.getNome()+"', '"+produtos.getClassificacao()+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean read(String classificacao){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Produtos WHERE classificacao = '"+classificacao+"'");

            //ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");
            
            System.out.println("codigo - nome - classificacao");
            while (rs.next()) {
                int cod = rs.getInt("codigo");
                String nome = rs.getString("nome");
            
                System.out.println(cod+ " - " +nome+ " - " +classificacao);
            }
            
            return true;
        }
        catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(int cod, String novoNome){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Produtos SET nome ='"+novoNome+"' WHERE codigo ="+cod);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(int cod){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Produtos WHERE codigo ="+cod);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
