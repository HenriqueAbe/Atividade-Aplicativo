import java.util.List;
import java.util.Scanner;

public class Menu {
    private Sistema sistema;
    private Scanner scanner;

    public Menu() {
        sistema = new Sistema();
        scanner = new Scanner(System.in);
        iniciar();
    }

    private void iniciar() {
        while(true) {
            exibirMenuPrincipal();
            processarOpcao();
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");

        List<Jogador> jogadores = sistema.getTodosJogador();
        for(int i = 0; i < jogadores.size(); i++) {
            System.out.println((i+1) + ". Acessar " + jogadores.get(i).getNome());
        }

        System.out.println((jogadores.size()+1) + ". Modo Administrador");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    private void processarOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao == 0) {
                System.exit(0);
            }
            else if(opcao == sistema.getTodosJogador().size()+1) {
                new MenuAdministrador(sistema, scanner).executar();
            }
            else if(opcao > 0 && opcao <= sistema.getTodosJogador().size()) {
                new MenuJogador(sistema.getJogador(opcao-1), scanner).exibirMenuJogador();
            }
            else {
                System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida!");
            scanner.nextLine();
        }
    }
}