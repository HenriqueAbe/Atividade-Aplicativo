public class ArmaPrincipal extends Arma {
    private int preco;

    public ArmaPrincipal(String nome, int preco) {
        super(nome);
        this.preco = preco;
    }

    @Override
    public String getTipo() {
        return "Principal | $" + preco;
    }
}