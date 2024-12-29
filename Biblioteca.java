import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso.");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public void procurarLivro(String titulo) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(livro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Procurar livro");
            System.out.println("4. Emprestar livro");
            System.out.println("5. Devolver livro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            if (opcao == 1) {
                System.out.print("Digite o título do livro: ");
                String titulo = scanner.nextLine();
                System.out.print("Digite o autor do livro: ");
                String autor = scanner.nextLine();
                Livro livro = new Livro(titulo, autor);
                biblioteca.adicionarLivro(livro);
            } else if (opcao == 2) {
                biblioteca.listarLivros();
            } else if (opcao == 3) {
                System.out.print("Digite o título do livro: ");
                String titulo = scanner.nextLine();
                biblioteca.procurarLivro(titulo);
            } else if (opcao == 4) {
                System.out.print("Digite o título do livro a ser emprestado: ");
                String titulo = scanner.nextLine();
                for (Livro livro : biblioteca.livros) {
                    if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                        livro.emprestar();
                        break;
                    }
                }
            } else if (opcao == 5) {
                System.out.print("Digite o título do livro a ser devolvido: ");
                String titulo = scanner.nextLine();
                for (Livro livro : biblioteca.livros) {
                    if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                        livro.devolver();
                        break;
                    }
                }
            } else if (opcao == 6) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
