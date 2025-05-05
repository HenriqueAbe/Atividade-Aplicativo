import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Jogador> jogadores;
    private Administrador admin;

    public Sistema() {
        this.jogadores = new ArrayList<>();
        this.admin = new Administrador("admin123");
    }

    public void carregarDadosIniciais() {
        jogadores.clear();

        Jogador j1 = new Jogador("Jogador1", "Platina");
        j1.adicionarArma(new ArmaPrimaria("Vandal", 510));
        j1.adicionarArma(new ArmaSecundaria("Classic", 400));

        Jogador j2 = new Jogador("Jogador2", "Diamante");
        j2.adicionarArma(new ArmaPrimaria("Phantom", 15234));
        j2.adicionarArma(new ArmaSecundaria("Sheriff", 9110));

        jogadores.add(j1);
        jogadores.add(j2);

        System.out.println("Sistema iniciado com " + jogadores.size() + " jogadores padrão.");
    }

    public boolean adicionarJogador(Jogador novoJogador) {
        if(novoJogador == null || novoJogador.getNome().trim().isEmpty()) {
            System.out.println("Nome do jogador não pode ser vazio!");
            return false;
        }

        jogadores.add(novoJogador);
        System.out.println("[SISTEMA] Jogador " + novoJogador.getNome() + " adicionado. Total: " + jogadores.size());
        return true;

    }

    public Jogador getJogador(int index) {
        if(index >= 0 && index < jogadores.size()) {
            return jogadores.get(index);
        }
        throw new IndexOutOfBoundsException("Índice de jogador inválido");
    }

    public List<Jogador> getTodosJogador() {
        return jogadores;
    }

    public boolean autenticarAdmin(String senha) {
        return admin.validarSenha(senha);
    }
}