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
        j1.adicionarArma(new ArmaPrincipal("Vandal", 2900));
        j1.adicionarArma(new ArmaSecundaria("Classic", 0));

        Jogador j2 = new Jogador("Jogador2", "Diamante");
        j2.adicionarArma(new ArmaPrincipal("Phantom", 2900));
        j2.adicionarArma(new ArmaSecundaria("Sheriff", 800));

        jogadores.add(j1);
        jogadores.add(j2);

        System.out.println("Sistema iniciado com " + jogadores.size() + " jogadores padrão.");
    }

    public boolean adicionarJogador(Jogador novoJogador) {
        if(novoJogador == null || novoJogador.getNome().trim().isEmpty()) {
            System.out.println("Nome do jogador não pode ser vazio!");
            return false;
        }

        boolean existe = jogadores.stream()
                .anyMatch(j -> j.getNome().equalsIgnoreCase(novoJogador.getNome()));

        if(!existe) {
            jogadores.add(novoJogador);
            System.out.println("[SISTEMA] Jogador " + novoJogador.getNome() + " adicionado. Total: " + jogadores.size());
            return true;
        } else {
            System.out.println("Já existe um jogador com este nome!");
            return false;
        }
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