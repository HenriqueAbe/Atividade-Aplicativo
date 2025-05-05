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
            System.out.println("2. Editar jogador");
            System.out.println("3. Adicionar novo jogador");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    listarJogador();
                    break;
                case 2:
                    editarJogadorDinamico();
                    break;
                case 3:
                    adicionarJogador();
                    break;
            }
        } while(opcao != 0);
    }

    private void editarJogadorDinamico() {
        listarJogador();
        System.out.print("\nDigite o número do jogador para editar: ");

        try {
            int numero = scanner.nextInt();
            scanner.nextLine();

            if(numero > 0 && numero <= sistema.getTodosJogador().size()) {
                editarJogador(numero - 1); // Ajuste para índice zero
            } else {
                System.out.println("Número inválido!");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida!");
            scanner.nextLine();
        }
    }

    private void editarJogador(int index) {
        Jogador j = sistema.getJogador(index);
        System.out.println("\nEditando: " + j.getNome() + " (Rank: " + j.getRank() + ")");

        System.out.print("Novo nome (atual: " + j.getNome() + "): ");
        String nome = scanner.nextLine();
        if(!nome.isEmpty()) {
            j.setNome(nome);
        }

        System.out.print("Novo rank (atual: " + j.getRank() + "): ");
        String rank = scanner.nextLine();
        if(!rank.isEmpty()) {
            j.setRank(rank);
        }

        System.out.println("\nDados atualizados:");
        System.out.println("Nome: " + j.getNome());
        System.out.println("Rank: " + j.getRank());
    }

    private void adicionarJogador() {
        System.out.println("\n--- ADICIONAR NOVO JOGADOR ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();

        if(nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio!");
            return;
        }

        System.out.print("Rank: ");
        String rank = scanner.nextLine().trim();
        rank = rank.isEmpty() ? "Sem rank" : rank;

        Jogador novo = new Jogador(nome, rank);
        if(sistema.adicionarJogador(novo)) {
            System.out.println("\n✔ Jogador adicionado com sucesso!");
            System.out.println("Lista atualizada:");
            listarJogador();
        }
    }

    private void listarJogador() {
        List<Jogador> jogadores = sistema.getTodosJogador();
        System.out.println("\n=== LISTA DE JOGADORES ===");

        if(jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
        } else {
            for(int i = 0; i < jogadores.size(); i++) {
                Jogador j = jogadores.get(i);
                System.out.println((i+1) + ". " + j.getNome() + " - " + j.getRank());
            }
        }
    }
}