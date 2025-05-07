import java.util.Scanner;
import java.util.List;

public class MenuJogador {
    private Jogador jogador;
    private Scanner scanner;

    public MenuJogador(Jogador jogador, Scanner scanner) {

        this.jogador = jogador;
        this.scanner = scanner;
    }

    public void exibirMenuJogador() {
        System.out.println("\nBem-vindo, " + jogador.getNome() + " Rank: " + jogador.getRank() + ".");

        int opcao;
        do {
            System.out.println("\nMenu de " + jogador.getNome() + ":");
            System.out.println("1. Ver perfil atual");
            System.out.println("2. Ver histórico");
            System.out.println("3. Adicionar partida");
            System.out.println("4. Adicionar arma favorita");
            System.out.println("5. Editar arma(s) favorita(s)");
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
                case 4:
                    adicionarArmaFavorita();
                    scanner.nextLine();
                    break;
                case 5:
                    editarArmaDinamico();
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

    private void adicionarArmaFavorita() {
        System.out.print("Digite o nome da sua arma favorita: ");
        String armaFavorita = scanner.nextLine();
        System.out.print("Primária (1), Secundária (2): ");
        int tipoArma = scanner.nextInt();
        System.out.print("Digite o número de kills: ");
        int kill = scanner.nextInt();

        if (tipoArma == 1) {
            jogador.adicionarArma(new ArmaPrimaria(armaFavorita,kill));
        } else if (tipoArma == 2) {
            jogador.adicionarArma(new ArmaSecundaria(armaFavorita, kill));
        }
    }

    private void listarArmas() {
        List<Arma> armas = Jogador.getTodasArmas();

        if (armas.isEmpty()) {
            System.out.println("Nenhuma arma registrada.");
        } else {
            for(int i = 0; i < armas.size(); i++) {
                System.out.println((i+1) + ". Editar " + armas.get(i).getNome());
            }
        }
    }

    private void editarArmaDinamico() {
        listarArmas();
        System.out.print("Digite o número da arma para editar: ");

        try {
            int numero = scanner.nextInt();
            scanner.nextLine();

            if (numero > 0 && numero <= Jogador.getTodasArmas().size()) {
                editarArma(numero - 1);
            } else {
                System.out.println("Número inválido!");
                scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida!");
            scanner.nextLine();
        }

    }

    private void editarArma(int index) {
        int opcao;

        do {
            System.out.println("\nDigite o número da sua edição: ");
            System.out.println("1. Editar tipo(Primária ou Secundária");
            System.out.println("2. Editar kills");
            System.out.println("0. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Jogador i =
            }
        }
    }
}