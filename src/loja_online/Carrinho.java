package loja_online;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private Comprador comprador;
    private List<Produto> produtos;
    private float total;

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
        this.produtos = new ArrayList<>();
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public void addProduto(Produto novoProduto) {
    	this.produtos.add(novoProduto);
    }
    public void removeProduto(Produto produto) {
    	this.produtos.remove(produto);
    }
    public List<Produto> getProdutos() {
        return produtos;
    }

    public float getTotal() {
        return total;
    }
}
