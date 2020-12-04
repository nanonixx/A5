import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

public class E22 {
    public static void main(String[] args) {

        System.out.println("EJERCICIO 2.2\n");

        byte [] data = "mensaje".getBytes();

        KeyPair keypair = Xifrar.randomGenerate(1024);
        PrivateKey privatekey = keypair.getPrivate();
        PublicKey publickey = keypair.getPublic();

        byte [][] encWrappedData = Xifrar.encryptWrappedData(data, publickey);

        System.out.println(Arrays.deepToString(encWrappedData));

        //no entiendo
    }
}
