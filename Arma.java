public abstract class Arma {
    protected String nome;

    public Arma(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return nome + " (" + getTipo() + ")";
    }

    public abstract String getTipo();
}