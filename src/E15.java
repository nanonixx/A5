import java.security.KeyPair;
import java.security.PrivateKey;

public class E15 {
    public static void main(String[] args) {

        System.out.println("EJERCICIO 1.5\n");

        byte [] data = "mensaje".getBytes();

        KeyPair keypair = Xifrar.randomGenerate(1024);
        PrivateKey privatekey = keypair.getPrivate();

        byte[] signature = Xifrar.signData(data, privatekey);

        System.out.println("Signatura: " + new String(signature));
    }
}
