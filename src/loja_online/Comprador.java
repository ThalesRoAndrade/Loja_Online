package loja_online;
import java.util.List;

public class Comprador extends Usuario {

	public Comprador(String email, String nome) {
		super(email, nome);
		// TODO Auto-generated constructor stub
	}

private Carrinho carrinho;
  
  private List<Avaliacao> avaliacao;
  
  public void adicionarProdutoAoCarrinho(Produto produto) {
  }

  public void removerProdutoDoCarrinho(Produto produto) {
  }

  public PedidoFinalizado finalizarCompra() {
	  return null;
  }

  public void adicionarAvaliacao(Avaliacao avaliacao) {
  }

  public List<Avaliacao> consultarAvaliacoes() {
    return null;
  }

  public List<Localizacao> visualizarLocaisDeVenda() {
    return null;
  }
}
