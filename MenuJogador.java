import java.util.Scanner;

public class MenuJogador {
    private Jogador jogador;
    private Scanner scanner;

    public MenuJogador(Jogador jogador, Scanner scanner) {
        this.jogador = jogador;
        this.scanner = scanner;
    }

    public void executar() {
        System.out.println("\nBem-vindo, " + jogador.getNome() + " (" + jogador.getRank() + ")!");

        int opcao;
        do {
            System.out.println("\nMenu de " + jogador.getNome() + ":");
            System.out.println("1. Ver perfil atual");
            System.out.println("2. Ver histórico");
            System.out.println("3. Adicionar partida");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    jogador.exibirPerfil();
                    scanner.nextLine();
                    break;
                case 2:
                    jogador.exibirHistorico();
                    scanner.nextLine();
                    break;
                case 3:
                    adicionarPartida();
                    scanner.nextLine();
                    break;
            }
        } while(opcao != 0);
    }

    private void adicionarPartida() {
        System.out.print("Resultado (Vitória/Derrota): ");
        String resultado = scanner.nextLine();

        System.out.print("Personagem: ");
        String personagem = scanner.nextLine();

        System.out.print("Placar (ex: 13-8): ");
        String placar = scanner.nextLine();

        System.out.print("Mapa: ");
        String mapa = scanner.nextLine();

        System.out.print("KDA (ex: 15/5/10): ");
        String kda = scanner.nextLine();

        jogador.adicionarHistorico(new Historico(resultado, personagem, placar, mapa, kda));
        System.out.println("Partida adicionada com sucesso!");

        jogador.exibirEstatisticas();
    }
}