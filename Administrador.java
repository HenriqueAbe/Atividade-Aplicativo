public class Administrador {
    private String senha;

    public Administrador(String senha) {
        this.senha = senha;
    }

    public boolean validarSenha(String tentativa) {
        return senha.equals(tentativa);
    }
}