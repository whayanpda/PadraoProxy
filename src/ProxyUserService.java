public class ProxyUserService implements UserService {

    private RealUserService realUserService;
    private boolean isAdmin;

    public ProxyUserService(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public void carregarUsuarios() {
        if (isAdmin) {
            if (realUserService == null) {
                realUserService = new RealUserService();
            }
            realUserService.carregarUsuarios();
        } else {
            System.out.println("Acesso negado. Você não tem permissão para carregar usuários.");
        }
    }

    @Override
    public void exibirUsuarios() {
        if (isAdmin) {
            if (realUserService == null) {
                realUserService = new RealUserService();
            }
            realUserService.exibirUsuarios();
        } else {
            System.out.println("Acesso negado. Você não tem permissão para exibir usuários.");
        }
    }
}
