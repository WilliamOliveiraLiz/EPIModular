import java.util.ArrayList;
import java.util.Scanner;

public class EPIModular {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> epis = new ArrayList<>();
        ArrayList<String> funcionarios = new ArrayList<>();
        ArrayList<String> emprestimos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== Sistema de Gerenciamento ===");
            System.out.println("1. Módulo de EPIs");
            System.out.println("2. Módulo de Funcionários");
            System.out.println("3. Módulo de Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    submenu("EPIs", epis);
                    break;
                case 2:
                    submenu("Funcionários", funcionarios);
                    break;
                case 3:
                    submenu("Empréstimos", emprestimos);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    public static void submenu(String nomeModulo, ArrayList<String> lista) {
        int opcao;
        do {
            System.out.println("\n--- Módulo de " + nomeModulo + " ---");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Remover");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    cadastrarItem(lista);
                    break;
                case 2:
                    listarItens(lista);
                    break;
                case 3:
                    atualizarItem(lista);
                    break;
                case 4:
                    removerItem(lista);
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    public static void cadastrarItem(ArrayList<String> lista) {
        input.nextLine();
        String entrada;
        do {
            System.out.print("Digite os dados (ex: \"Capacete - 20 unidades - Proteção para a cabeça\"): ");
            entrada = input.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Cadastro inválido. O campo não pode estar vazio.");
            }
        } while (entrada.isEmpty());

        lista.add(entrada);
        System.out.println("Item cadastrado com sucesso!");
    }

    public static void listarItens(ArrayList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Itens ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
    }

    public static void atualizarItem(ArrayList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum item para atualizar.");
            return;
        }
        listarItens(lista);
        System.out.print("Digite o índice do item que deseja atualizar: ");
        int indice = lerInteiro();

        if (indice < 0 || indice >= lista.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        input.nextLine();
        System.out.print("Digite os novos dados: ");
        String novosDados = input.nextLine().trim();

        if (novosDados.isEmpty()) {
            System.out.println("Atualização cancelada. O campo não pode estar vazio.");
            return;
        }

        lista.set(indice, novosDados);
        System.out.println("Item atualizado com sucesso!");
    }

    public static void removerItem(ArrayList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum item para remover.");
            return;
        }
        listarItens(lista);
        System.out.print("Digite o índice do item que deseja remover: ");
        int indice = lerInteiro();

        if (indice < 0 || indice >= lista.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        lista.remove(indice);
        System.out.println("Item removido com sucesso!");
    }

    public static int lerInteiro() {
        while (!input.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número.");
            input.next();
        }
        return input.nextInt();
    }
}
