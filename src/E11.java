import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 1.1\n");

        KeyPair keypair = Xifrar.randomGenerate(1024);

        Scanner input = new Scanner(System.in);

        System.out.print("Mensaje a encriptar:  ");
        byte[] msg = input.nextLine().getBytes();

        PublicKey publickey = keypair.getPublic();
        PrivateKey privatekey = keypair.getPrivate();

        byte[] datos = Xifrar.encryptData(msg, publickey);
        System.out.println("Mensaje encriptado: " + new String(datos));

        System.out.println("Mensaje desencriptado: " + Xifrar.decryptData(datos, privatekey));

    }
}
