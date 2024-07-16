public class PadraoProxytest {

    public static void main(String[] args) {

        UserService proxyAdmin = new ProxyUserService(true);

        proxyAdmin.carregarUsuarios();
        proxyAdmin.exibirUsuarios();

        System.out.println();

        UserService proxyUser = new ProxyUserService(false);

        proxyUser.carregarUsuarios();
        proxyUser.exibirUsuarios();
    }
}
