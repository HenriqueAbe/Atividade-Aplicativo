import java.util.List;
import java.util.Scanner;

public class MenuAdministrador {
    private Sistema sistema;
    private Scanner scanner;

    public MenuAdministrador(Sistema sistema, Scanner scanner) {
        this.sistema = sistema;
        this.scanner = scanner;
    }

    public void executar() {
        System.out.print("\nDigite a senha de admin: ");
        if (!sistema.autenticarAdmin(scanner.nextLine())) {
            System.out.println("Acesso negado!");
            return;
        }

        int opcao;
        do {
            System.out.println("\n=== MODO ADMIN ===");
            System.out.println("1. Listar jogadores");
            System.out.println("2. Editar Jogador 1");
            System.out.println("3. Editar Jogador 2");
            System.out.println("4. Adicionar novo jogador");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarJogador();
                    scanner.nextLine();
                    break;
                case 2:
                    editarJogador(0);
                    scanner.nextLine();
                    break;
                case 3:
                    editarJogador(1);
                    scanner.nextLine();
                    break;
                case 4:
                    adicionarJogador();
                    scanner.nextLine();
                    break;
            }
        } while (opcao != 0);
    }

    private void editarJogador(int index) {
        Jogador j = sistema.getJogador(index);
        System.out.println("\nEditando jogador: " + j.getNome() + " (Rank: " + j.getRank() + ")");

        System.out.print("Novo nome (atual: " + j.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            j.setNome(nome);
            System.out.println("Nome alterado para: " + j.getNome());
        }

        System.out.print("Novo rank (atual: " + j.getRank() + "): ");
        String rank = scanner.nextLine();
        if (!rank.isEmpty()) {
            j.setRank(rank);
            System.out.println("Rank alterado para: " + j.getRank());
        }

        System.out.println("\nDados atualizados:");
        System.out.println("Nome: " + j.getNome());
        System.out.println("Rank: " + j.getRank());
    }

    private void adicionarJogador() {
        System.out.print("\nNome do novo jogador: ");
        String nome = scanner.nextLine().trim();

        if(nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio!");
            return;
        }

        // Verifica se jogador já existe
        if(sistema.getTodosJogador().stream().anyMatch(j -> j.getNome().equalsIgnoreCase(nome))) {
            System.out.println("Já existe um jogador com este nome!");
            return;
        }

        System.out.print("Rank inicial: ");
        String rank = scanner.nextLine().trim();

        if(rank.isEmpty()) {
            rank = "Sem rank";
        }

        // Usa o método específico do sistema para adicionar
        sistema.adicionarJogador(new Jogador(nome, rank));

        // Mostra lista atualizada
        System.out.println("\n✔ Jogador adicionado com sucesso!");
        System.out.println("Lista atual de jogadores:");
        listarJogador();
    }

    private void listarJogador() {
        System.out.println("\n=== LISTA DE JOGADORES ===");
        List<Jogador> todos = sistema.getTodosJogador();

        if(todos.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
        } else {
            for(int i = 0; i < todos.size(); i++) {
                Jogador j = todos.get(i);
                System.out.printf("%d. %s - %s (Partidas: %d)\n",
                        i+1, j.getNome(), j.getRank(), j.getHistorico().size());
            }
        }
    }
}