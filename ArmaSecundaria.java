public class ArmaSecundaria extends Arma {
    private int preco;

    public ArmaSecundaria(String nome, int preco) {
        super(nome);
        this.preco = preco;
    }

    public String getTipo() {
        return "Secundária | $" + preco;
    }
}