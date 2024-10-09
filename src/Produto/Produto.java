package Produto;

public abstract class Produto {
    private String nome;
    private float preco;
    private String codigoLegado;

    public Produto(String nome, float preco, String codigoLegado) {
        this.nome = nome;
        this.preco = preco;
        this.codigoLegado = codigoLegado;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCodigoLegado() {
        return codigoLegado;
    }

    public void setCodigoLegado(String codigoLegado) {
        this.codigoLegado = codigoLegado;
    }


    public abstract String getDetalhes();
}