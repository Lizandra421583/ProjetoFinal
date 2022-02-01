package Conexao;

public class Produtos
{
    private String nome;
    private String classificacao;
  
    public Produtos(String nome, String classificacao)
    {
        this.nome = nome;
        this.classificacao = classificacao;
    }
 
    public String getNome(){
        return nome;
    }
     public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getClassificacao(){
        return classificacao;
    }
     public void setClassificacao(String classificacao){
        this.classificacao = classificacao;
    }
}
