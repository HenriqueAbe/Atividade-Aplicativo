public class ArmaPrincipal extends Arma {
    private int preco;

    public ArmaPrincipal(String nome, int preco) {
        super(nome);
        this.preco = preco;
    }

    public String getTipo() {
        return "Principal | $" + preco;
    }
}