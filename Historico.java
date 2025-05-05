public class Historico {
    private String resultado;
    private String personagem;
    private String placar;
    private String mapa;  // Novo campo
    private String kda;   // Novo campo

    public Historico(String resultado, String personagem, String placar, String mapa, String kda) {
        this.resultado = resultado;
        this.personagem = personagem;
        this.placar = placar;
        this.mapa = mapa;
        this.kda = kda;
    }

    // Novo getter para resultado
    public String getResultado() {
        return resultado;
    }

    public String toString() {
        return String.format("%s como %s | %s (%s) | KDA: %s",
                resultado, personagem, placar, mapa, kda);
    }
}