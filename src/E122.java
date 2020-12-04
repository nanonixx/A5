import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.util.Enumeration;

public class E122 {
    public static void main(String[] args) throws Exception {

        System.out.println("EJERCICIO 1.2.2\n");

        String ksFilePath = "/home/dam2a/.keystore";
        String password = "passwd";

        KeyStore ks = Xifrar.loadKeyStore(ksFilePath, password);

        SecretKey clauSimetrica = Xifrar.keygenKeyGeneration(128);

        KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(clauSimetrica);
        KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(password.toCharArray());


        ks.setEntry("newKey", skEntry, protParam);


        java.io.FileOutputStream fos = null;
        try {
            fos = new java.io.FileOutputStream("newKeyStoreName");
            ks.store(fos, password.toCharArray());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }

        Enumeration<String> aliases = ks.aliases();
        System.out.print("Alias de las claves: ");
        while(aliases.hasMoreElements()){
            System.out.print(aliases.nextElement()+"  ");
        }



    }
}
