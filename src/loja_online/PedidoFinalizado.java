package loja_online;

import java.util.List;
import java.util.Random;

public class PedidoFinalizado extends Carrinho {
	public static int totalPedidosFinalizados; // Atributo estático
	public int ID;
	private Carrinho carrinho;
	

	public static int getTotalPedidosFinalizados() { // Método estático para acessar o total de pedidos finalizados
	        return totalPedidosFinalizados;
	}

	PedidoFinalizado(Carrinho carrinho){
		this.ID = Integer.parseInt(this.generateRandomNumberString(8));
		this.carrinho = carrinho;
		totalPedidosFinalizados++; // Incrementa o contador de pedidos finalizados
	}
	public void emitirNotaFiscal() {
		List<Produto> comprados = this.carrinho.getProdutos();
		System.out.println("ID da nota fiscal: " + this.ID);
		for(Produto comprado : comprados) {
			System.out.println(comprado.getNome() + " R$:" + comprado.getPreco());
		}
    }
	private String generateRandomNumberString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(10); // Generates a random number between 0 and 9
            sb.append(randomNumber);
        }
        return sb.toString();
    }
}