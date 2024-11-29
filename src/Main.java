// import java.util.ArrayList;
// import java.util.Scanner;

// public class Main {
//     static ArrayList<Produto> estoque = new ArrayList<>();
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in, "UTF-8");

//         int opcao = -1;

//         do {
//             System.out.println("\nMenu:");
//             System.out.println("\n1. Listar estoque");
//             System.out.println("2. Criar produto");
//             System.out.println("3. Deletar produto");
//             System.out.println("4. Alterar produto");
//             System.out.println("5. Buscar produto");
//             System.out.println("0. Sair");
//             System.out.print("\nDigite uma opção: ");
    
//             if (scanner.hasNextInt()) {
//                 opcao = scanner.nextInt();
//                 scanner.nextLine();
    
//                 switch (opcao) {
//                     case 1 -> listarEstoque();
//                     case 2 -> criarProduto(scanner);
//                     case 3 -> deletarProduto(scanner);
//                     case 4 -> alterarProduto(scanner);
//                     case 5 -> buscarProduto(scanner);
//                     case 0 -> sairDoSistema();
//                     default -> System.out.println("\nOpcao invalida! Escolha um numero entre 0 e 5.");
//                 }
//             } else {
//                 System.out.println("Entrada invalida! Por favor, insira apenas numeros.");
//                 scanner.nextLine();
//             }
//         } while (opcao != 0);
//     }
    
//     private static void listarEstoque() {
//         if (estoque.isEmpty()) {
//             System.out.println("\nO estoque esta vazio. Nao ha produtos para listar.");
//             return;
//         }

//         for (int i = 0; i < estoque.size(); i++) {
//             Produto produto = estoque.get(i);
//             System.out.println("Indice: " + i);
//             System.out.println("\nNome: " + produto.getNome());
//             System.out.println("Descricao: " + produto.getDescricao());
//             System.out.println("Marca: " + produto.getMarca());
//             System.out.println("Modelo: " + produto.getModelo());
//             System.out.println("Ano: " + produto.getAno());
//             System.out.println("Preco: R$ " + produto.getPreco());
//             System.out.println("\n------------------------");
    
//         }
//     }

//     private static void criarProduto(Scanner scanner) {
//         System.out.print("\nDigite o nome do produto: ");
//         String nome = scanner.nextLine();

//         System.out.print("Escreva a descricao do produto: ");
//         String descricao = scanner.nextLine();

//         System.out.print("Qual a marca do produto: ");
//         String marca = scanner.nextLine();

//         System.out.print("Qual o modelo do produto: ");
//         String modelo = scanner.nextLine();
        
//         System.out.print("Qual o ano de fabricacao do produto: ");
//         int ano = scanner.nextInt();

//         System.out.print("Qual o preco do produto: ");
//         double preco = scanner.nextDouble();

//         Peca novaPeca = new Peca(nome, descricao, marca, modelo, ano, preco);
    
//         estoque.add(novaPeca);
//         System.out.println("\nProduto criado com sucesso!");
//     }

//     private static void deletarProduto(Scanner scanner) {
//         if (estoque.isEmpty()) {
//             System.out.println("\nO estoque esta vazio. Nao ha produtos para deletar.");
//             return;
//         }
    
//         listarEstoque();
    
//         System.out.println("\nDigite o indice do produto que deseja deletar (comeca em 0): ");
//         int indice = scanner.nextInt();
//         scanner.nextLine();
    
//         if (indice >= 0 && indice < estoque.size()) {
//             Produto produtoRemovido = estoque.remove(indice);
//             System.out.println("\nProduto removido com sucesso: " + produtoRemovido.getNome());
//         } else {
//             System.out.println("\nIndice invalido. Operacao cancelada.");
//         }
//     }

//     private static void sairDoSistema() {
//         System.out.println("Encerrando o sistema...");
//         System.exit(0);
//     }

//     private static void alterarProduto(Scanner scanner) {
//         if (estoque.isEmpty()) {
//             System.out.println("O estoque esta vazio. Nao ha produtos para alterar.");
//             return;
//         }
    
//         listarEstoque();
    
//         System.out.println("Digite o indice do produto que deseja alterar (comeca em 0): ");
//         int indice = scanner.nextInt();
//         scanner.nextLine();
    
//         if (indice >= 0 && indice < estoque.size()) {
//             Produto produto = estoque.get(indice);
    
//             System.out.println("Alterando o produto: " + produto.getNome());
//             System.out.print("Digite o novo nome (ou pressione Enter para manter '" + produto.getNome() + "'): ");
//             String nome = scanner.nextLine();
//             if (!nome.isEmpty()) produto.setNome(nome);
    
//             System.out.print("Digite a nova descricao (ou pressione Enter para manter '" + produto.getDescricao() + "'): ");
//             String descricao = scanner.nextLine();
//             if (!descricao.isEmpty()) produto.setDescricao(descricao);
    
//             System.out.print("Digite a nova marca (ou pressione Enter para manter '" + produto.getMarca() + "'): ");
//             String marca = scanner.nextLine();
//             if (!marca.isEmpty()) produto.setMarca(marca);
    
//             System.out.print("Digite o novo modelo (ou pressione Enter para manter '" + produto.getModelo() + "'): ");
//             String modelo = scanner.nextLine();
//             if (!modelo.isEmpty()) produto.setModelo(modelo);
    
//             System.out.print("Digite o novo ano (ou pressione Enter para manter '" + produto.getAno() + "'): ");
//             String anoInput = scanner.nextLine();
//             if (!anoInput.isEmpty()) produto.setAno(Integer.parseInt(anoInput));
    
//             System.out.print("Digite o novo preco (ou pressione Enter para manter 'R$" + produto.getPreco() + "'): ");
//             String precoInput = scanner.nextLine();
//             if (!precoInput.isEmpty()) produto.setPreco(Double.parseDouble(precoInput));
    
//             System.out.println("Produto alterado com sucesso!");
//         } else {
//             System.out.println("Indice invalido. Operacao cancelada.");
//         }
//     }

//     private static void buscarProduto(Scanner scanner) {
//         System.out.print("Digite o nome do produto a ser buscado: ");
//         String nome = scanner.nextLine();
//         boolean encontrado = false;

//         for (Produto produto : estoque) {
//             if (produto.getNome().equalsIgnoreCase(nome)) {
//                 System.out.println(produto.getNome());
//                 encontrado = true;
//             }
//         }

//         if (!encontrado) {
//             System.out.println("Produto nao encontrado.");
//         }
//     }
// }