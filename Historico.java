public class Historico {
    private String resultado;
    private String personagem;
    private String placar;
    private String mapa;
    private String kda;

    public Historico(String resultado, String personagem, String placar, String mapa, String kda) {
        this.resultado = resultado;
        this.personagem = personagem;
        this.placar = placar;
        this.mapa = mapa;
        this.kda = kda;
    }

    public String getResultado() {
        return resultado;
    }

    public String toString() {
        return String.format("%s | %s | %s (%s) | KDA: %s",
                resultado, personagem, placar, mapa, kda);
    }
}