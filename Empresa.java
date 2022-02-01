package Conexao;

public class Empresa
{
    private String razaosocial;
    private String cnpj;
    private String endereco;
    private String telefone;

    public Empresa(String razaosocial, String cnpj, String endereco, String telefone)
    {
        this.razaosocial = razaosocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }
 
    public String getRazaosocial(){
        return razaosocial;
    }
     public void setRazaosocial(String razaosocial){
        this.razaosocial = razaosocial;
    }
    
    public String getCnpj(){
        return cnpj;
    }
     public void setCnpj(String cnpj){
        this.cnpj = cnpj;
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
}
