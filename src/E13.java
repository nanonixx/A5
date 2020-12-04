import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.security.cert.CertificateException;

public class E13 {
    public static void main(String[] args) throws CertificateException, FileNotFoundException {

        System.out.println("EJERCICIO 1.3\n");

        String pathCer = "/home/dam2a/premis/jordi.cer";
        PublicKey pk = Xifrar.getPublicKey(pathCer);

        System.out.println(pk);
    }

}
