package Conexao;

public class Cliente
{
    private String nome;
    private String endereco;
    private String telefone;
    private String data;
    private String compra;
    private String pagamento;

    public Cliente(String nome, String endereco, String telefone, String data, String compra, String pagamento)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data = data;
        this.compra = compra;
        this.pagamento = pagamento;
    }
 
    public String getNome(){
        return nome;
    }
     public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEndereco(){
        return endereco;
    }
     public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getTelefone(){
        return telefone;
    }
     public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getData(){
        return data;
    }
     public void setData(String data){
        this.data = data;
    }
    
    public String getCompra(){
        return compra;
    }
     public void setCompra(String compra){
        this.compra = compra;
    }
    
    public String getPagamento(){
        return pagamento;
    }
     public void setPagamento(String pagamento){
        this.pagamento = pagamento;
    }
}
