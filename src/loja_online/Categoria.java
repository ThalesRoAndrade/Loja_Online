package loja_online;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private String nome;
	
	private List<Produto> produtos;
	
	Categoria(String nome){
		this.nome = nome;
		this.produtos = new ArrayList<>();
	}
	
	public String getNome() {
	  return nome;
	}

	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public void removerProduto(Produto produto) {
		
	}
	
	public List<Produto> consultarProdutos() {
		return null;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


}