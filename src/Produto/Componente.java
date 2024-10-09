package Produto;

public class Componente extends Produto {
    private String tipoMaterial;
    private boolean importado;

    public Componente(String nome, float preco, String codigoLegado, String tipoMaterial, boolean importado) {
        super(nome, preco, codigoLegado);
        this.tipoMaterial = tipoMaterial;
        this.importado = importado;
    }

    // Getters e Setters
    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    @Override
    public String getDetalhes() {
        return "Componente: " + getNome() + ", Preço: " + getPreco() + ", Material: " + tipoMaterial + ", Importado: " + (importado ? "Sim" : "Não");
    }
}