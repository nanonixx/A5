import java.security.KeyStore;

public class E4 {
    public static void main(String[] args) throws Exception {

        System.out.println("EJERCICIO 4\n");

        String ksFilePath = "/home/dam2a/.keystore";
        String password = "passwd";

        KeyStore ks = Xifrar.loadKeyStore(ksFilePath, password);



    }
}
