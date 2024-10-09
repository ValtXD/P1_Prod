package Controller;
import Produto.Produto;

import java.util.ArrayList;

public class ProdutoController {
    private ArrayList<Produto> produtos;

    public ProdutoController() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }
}