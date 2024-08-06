import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PadraoProxytest {

    private RealUserService realUserService;
    private ProxyUserService proxyAdmin;
    private ProxyUserService proxyUser;

    @Before
    public void setUp() {
        realUserService = new RealUserService();
        proxyAdmin = new ProxyUserService(true);
        proxyUser = new ProxyUserService(false);
    }

    @Test
    public void testCarregarUsuariosComPermissaoDeAdministrador() {
        proxyAdmin.carregarUsuarios();
        List<String> usuarios = proxyAdmin.getUsuarios();
        assertEquals(3, usuarios.size());
        assertTrue(usuarios.contains("User 1"));
        assertTrue(usuarios.contains("User 2"));
        assertTrue(usuarios.contains("User 3"));
    }

    @Test
    public void testCarregarUsuariosSemPermissaoDeAdministrador() {
        proxyUser.carregarUsuarios();
        List<String> usuarios = proxyUser.getUsuarios();
        assertEquals(0, usuarios.size());
    }

    @Test
    public void testExibirUsuariosComPermissaoDeAdministrador() {
        proxyAdmin.carregarUsuarios();
        proxyAdmin.exibirUsuarios();
        List<String> usuarios = proxyAdmin.getUsuarios();
        assertEquals(3, usuarios.size());
        assertTrue(usuarios.contains("User 1"));
        assertTrue(usuarios.contains("User 2"));
        assertTrue(usuarios.contains("User 3"));
    }

    @Test
    public void testExibirUsuariosSemPermissaoDeAdministrador() {
        proxyUser.exibirUsuarios();
        List<String> usuarios = proxyUser.getUsuarios();
        assertEquals(0, usuarios.size());
    }

    @Test
    public void testListaVaziaQuandoNenhumUsuarioCarregado() {
        List<String> usuariosAdmin = proxyAdmin.getUsuarios();
        List<String> usuariosUser = proxyUser.getUsuarios();
        assertTrue(usuariosAdmin.isEmpty());
        assertTrue(usuariosUser.isEmpty());
    }

    @Test
    public void testRealUserServiceDiretamente() {
        realUserService.carregarUsuarios();
        List<String> usuarios = realUserService.getUsuarios();
        assertEquals(3, usuarios.size());
        assertTrue(usuarios.contains("User 1"));
        assertTrue(usuarios.contains("User 2"));
        assertTrue(usuarios.contains("User 3"));
    }


}
