public class RealUserService implements UserService {
    @Override
    public void carregarUsuarios() {
        System.out.println("Carregando usuários do servidor...");

    }

    @Override
    public void exibirUsuarios() {
        System.out.println("Exibindo usuários do servidor...");
    }
}
