package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudCliente
{
    private Connection conexao;
    public CrudCliente(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean create(String nome, String endereco, String telefone, String data, String compra, String pagamento){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Cliente VALUES('"+nome+"', '"+endereco+"','"+telefone+"','"+data+"',"+compra+",'"+pagamento+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean create(Cliente cliente){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Cliente VALUES('"+cliente.getNome()+"', '"+cliente.getEndereco()+"','"+cliente.getTelefone()+"','"+cliente.getData()+"',"+cliente.getCompra()+",'"+cliente.getPagamento()+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean read(String telefone){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente WHERE telefone = '"+telefone+"'");

            //ResultSet rs = statement.executeQuery("SELECT * FROM Cliente");
            
            System.out.println("nome - endereco - telefone - data.da.compra - produtos.comprados - forma.de.pagamento");
            while (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String data = rs.getString("data.da.compra");
                String prod = rs.getString("produtos.comprados");
                String pag = rs.getString("forma.de.pagamento");

                System.out.println( nome+ " - " +endereco+ " - " +telefone+ " - " +data+ " - " +prod+ " - " +pag);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(String telefone, String novoEndereco){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Cliente SET endereco ='"+novoEndereco+"' WHERE telefone ='"+telefone+"'");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(String telefone){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Cliente WHERE telefone ="+telefone+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
