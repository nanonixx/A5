import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class E16 {
    public static void main(String[] args) {

        System.out.println("EJERCICIO 1.6\n");

        byte [] data = "mensaje".getBytes();

        KeyPair keypair = Xifrar.randomGenerate(1024);
        PrivateKey privatekey = keypair.getPrivate();
        PublicKey publickey = keypair.getPublic();

        byte[] signature = Xifrar.signData(data, privatekey);

        boolean valid = Xifrar.validateSignature(data, signature, publickey);
        System.out.println(valid? "La información es válida" : "La información no es válida");
    }
}
