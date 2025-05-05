public abstract class Arma {
    private String nome;

    public Arma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome + " " + getTipo() + " ";
    }

    public abstract String getTipo();
}