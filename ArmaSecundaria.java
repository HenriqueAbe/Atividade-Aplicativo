public class ArmaSecundaria extends Arma {
    private int kill;

    public ArmaSecundaria(String nome, int kill) {
        super(nome);
        this.kill = kill;
    }

    public String getTipo() {
        return " (Secundária) | Kills: " + kill;
    }
}