import java.security.KeyPair;
import java.security.PrivateKey;

public class E5 {
    public static void main(String[] args) {

        System.out.println("EJERCICIO 5\n");

        byte [] data = "mensaje".getBytes();

        KeyPair keypair = Xifrar.randomGenerate(1024);
        PrivateKey privatekey = keypair.getPrivate();

        byte[] signature = Xifrar.signData(data, privatekey);

        System.out.println("Signatura: " + signature);
    }
}
