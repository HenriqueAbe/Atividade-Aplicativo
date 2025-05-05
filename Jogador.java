import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private String rank;
    private List<Arma> armas;
    private List<Historico> historico;

    public Jogador(String nome, String rank) {
        this.nome = nome;
        this.rank = rank;
        this.armas = new ArrayList<>();
        this.historico = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public String getRank() {
        return rank;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }

    public void adicionarArma(Arma arma) {
        armas.add(arma);
    }

    public void adicionarHistorico(Historico historico) {
        this.historico.add(historico);
    }

    public void exibirPerfil() {
        System.out.println("\n=== PERFIL ATUALIZADO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Rank: " + rank);

        System.out.println("\nArmas preferidas:");
        if (armas.isEmpty()) {
            System.out.println("Nenhuma arma registrada.");
        } else {
            armas.forEach(arma -> System.out.println("- " + arma));
        }
    }

    public void exibirHistorico() {
        System.out.println("\n=== HISTÓRICO ===");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma partida registrada.");
        } else {
            historico.forEach(h -> System.out.println("- " + h));
        }
    }

    public List<Historico> getHistorico() {
        return new ArrayList<>(historico);
    }

    public void exibirEstatisticas() {
        System.out.println("\n=== ESTATÍSTICAS ===");
        System.out.println("Total de partidas: " + historico.size());

        long vitorias = historico.stream()
                .filter(h -> h.getResultado().equalsIgnoreCase("Vitória"))
                .count();

        System.out.printf("Vitórias: %d (%.1f%%)\n",
                vitorias, historico.isEmpty() ? 0 : (vitorias * 100.0 / historico.size()));
        }
    }