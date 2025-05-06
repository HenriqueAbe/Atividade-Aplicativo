import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Jogador> jogadores;
    private Administrador admin;

    public Sistema() {
        this.jogadores = new ArrayList<>();
        this.admin = new Administrador("admin123");
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