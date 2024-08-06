import java.util.List;

public class ProxyUserService implements UserService {
    private RealUserService realUserService = new RealUserService();
    private boolean isAdmin;

    public ProxyUserService(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public void carregarUsuarios() {
        if (isAdmin) {
            realUserService.carregarUsuarios();
        } else {
            System.out.println("Permissão negada: Apenas administradores podem carregar usuários.");
        }
    }

    @Override
    public void exibirUsuarios() {
        if (isAdmin) {
            realUserService.exibirUsuarios();
        } else {
            System.out.println("Permissão negada: Apenas administradores podem exibir usuários.");
        }
    }

    public List<String> getUsuarios() {
        return realUserService.getUsuarios();
    }


}
