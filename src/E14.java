import java.security.KeyStore;

public class E14 {
    public static void main(String[] args) throws Exception {

        System.out.println("EJERCICIO 1.4\n");

        String ksFilePath = "/home/naomi/.keystore";
        String password = "passwd";

        KeyStore ks = Xifrar.loadKeyStore(ksFilePath, password);

        System.out.println(Xifrar.getPublicKey(ks, "lamevaclaum9", password));
    }
}
