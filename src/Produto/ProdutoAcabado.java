package Produto;

public class ProdutoAcabado extends Produto {
    private int garantia;
    private int quantidadePalete;

    public ProdutoAcabado(String nome, float preco, String codigoLegado, int garantia, int quantidadePalete) {
        super(nome, preco, codigoLegado);
        this.garantia = garantia;
        this.quantidadePalete = quantidadePalete;
    }

    // Getters e Setters
    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public int getQuantidadePalete() {
        return quantidadePalete;
    }

    public void setQuantidadePalete(int quantidadePalete) {
        this.quantidadePalete = quantidadePalete;
    }

    @Override
    public String getDetalhes() {
        return "Produto Acabado: " + getNome() + ", Preço: " + getPreco() + ", Garantia: " + garantia + " meses, Quantidade por Palete: " + quantidadePalete;
    }
}