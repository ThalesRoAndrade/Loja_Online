package loja_online;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loja {
	public static void main(String[] args) {
		ArrayList<Categoria> categorias = Loja.CategoriasProdutosExtrair();
        Scanner scanner = new Scanner(System.in);

        String name = "";
        String email = "";

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Bem vindo a nossa loja.\nEntre seu nome e email (nome email): ");
            String input = scanner.nextLine();

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please enter both name and email separated by a space.");
            } else {
                name = parts[0];
                email = parts[1];

                if (isValidEmail(email)) {
                    validInput = true;
                } else {
                    System.out.println("Invalid email format. Please enter a valid email address.");
                }
            }
        }
        Carrinho carrinho = new Carrinho();
        Comprador comprador = new Comprador(name, email);
        carrinho.setComprador(comprador);

        while (true) {
            System.out.println("CATEGORIAS\n------------");
            for (int i = 0; i < categorias.size(); i++) {
                System.out.println(i + ". " + categorias.get(i).getNome());
            }

            System.out.print("\nDigite o número da categoria para ver os produtos:");
            int categoriaIndex = Integer.parseInt(scanner.nextLine());
            Categoria categoriaAtual = categorias.get(categoriaIndex);

            for (Produto produto : categoriaAtual.getProdutos()) {
                System.out.println(produto.getNome());
            }

            boolean nosProdutos = true;
            while (nosProdutos) {
                System.out.print("Digite os comandos do carrinho (add, listar, remov, voltar, finalizar):");
                String input = scanner.nextLine().toLowerCase();

                switch (input) {
                    case "add":
                        System.out.print("Digite o índice do produto:");
                        int itemIndex = Integer.parseInt(scanner.nextLine());
                        Produto produtoSelecionado = categoriaAtual.getProdutos().get(itemIndex);
                        carrinho.addProduto(produtoSelecionado);
                        break;
                    case "listar":
                        List<Produto> lista = carrinho.getProdutos();
                        for (Produto produto : lista) {
                            System.out.println(produto.getNome());
                        }
                        break;
                    case "remov":
                        List<Produto> listaProdutos = carrinho.getProdutos();
                        if (!listaProdutos.isEmpty()) {
                            for (int i = 0; i < listaProdutos.size(); i++) {
                                System.out.println(i + ". " + listaProdutos.get(i).getNome());
                            }
                            System.out.print("Digite o índice do produto:");
                            int itemIndex1 = Integer.parseInt(scanner.nextLine());
                            listaProdutos.remove(itemIndex1);
                            carrinho.setProdutos(listaProdutos);
                        } else {
                            System.out.println("Sem produtos no carrinho.");
                        }
                        break;
                    case "finalizar":
                        List<Produto> listaProdutos2 = carrinho.getProdutos();
                        float total = 0f;
                        if (!listaProdutos2.isEmpty()) {
                            for (Produto produto : listaProdutos2) {
                                System.out.println(produto.getNome() + " R$:" + produto.getPreco());
                                total += produto.getPreco();
                            }
                        }
                        System.out.println("Total: R$:" + total);
                        System.out.print("Finalizar? Y/N");
                        String confirmInput = scanner.nextLine();
                        if (confirmInput.equalsIgnoreCase("Y")) {
                            PedidoFinalizado finalizado = new PedidoFinalizado(carrinho);
                            finalizado.emitirNotaFiscal();
                            System.exit(0);
                        }
                        break;
                    case "voltar":
                        nosProdutos = false;
                        break;
                    default:
                        System.out.println("Comando inválido. Tente novamente.");
                }
            }
        }

    }

    private static boolean isValidEmail(String email) {
        // Regex pattern for email validation
    	String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        return email.matches(emailRegex);
    }
    private static ArrayList<Categoria> CategoriasProdutosExtrair() {
    	ArrayList<Categoria> categorias = new ArrayList<>();
    	try {
    		Path filePath = Paths.get(("./external/produtos.txt"));
    		File file = filePath.toFile();
    		Scanner scanner  = new Scanner(file);
    		Categoria CategoriaAtual = new Categoria(scanner.nextLine());
    		categorias.add(CategoriaAtual);
    		int Quant = 1;
    		while (scanner.hasNextLine()) {
                 String productName = scanner.nextLine();
                 if(productName != "") {
                	 if(Quant == 0) {
                		 categorias.add(new Categoria(productName));
                	 }else {
                		 categorias.get(categorias.size()-1).adicionarProduto(new Produto(productName,10.0f,"desc"));
                	 }
                	 Quant++;
                 }else {
                	 Quant = 0;
                 }
            }
    	}catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return categorias;
    }

}
