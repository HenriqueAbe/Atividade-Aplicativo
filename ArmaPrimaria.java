public class ArmaPrimaria extends Arma {
    private int kill;

    public ArmaPrimaria(String nome, int kill) {
        super(nome);
        this.kill = kill;
    }

    public String getTipo() {
        return " (Primária) | Kills: " + kill;
    }
}