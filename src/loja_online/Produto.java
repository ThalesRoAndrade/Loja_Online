package loja_online;

import java.util.List;

public class Produto {
	
	private String nome;
	
	private float preco;

	private String descricao;
	 
	public List<Categoria> categoria;
	
	Produto(String nome, float preco, String desc){
		this.nome = nome;
		this.preco = preco;
		this.descricao = desc;
	}

	public String getNome() {
		return nome;
	}

	public float getPreco() {
		return preco;
	}

	public String getDescrição() {
		return descricao;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}
	
	public String adicionarProdutos(Produto produto) {
		return null;
	}
	
	public String removerProdutos(Produto produto) {
		return null;
	}

}
