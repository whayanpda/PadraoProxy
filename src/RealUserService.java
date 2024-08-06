import java.util.ArrayList;
import java.util.List;

public class RealUserService implements UserService {
    private List<String> usuarios = new ArrayList<>();

    @Override
    public void carregarUsuarios() {
        usuarios.add("User 1");
        usuarios.add("User 2");
        usuarios.add("User 3");
    }

    @Override
    public void exibirUsuarios() {
        for (String usuario : usuarios) {
            System.out.println("Usuario: " + usuario);
        }
    }

    public List<String> getUsuarios() {
        return usuarios;
    }
}
